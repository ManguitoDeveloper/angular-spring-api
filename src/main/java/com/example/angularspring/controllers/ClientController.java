package com.example.angularspring.controllers;

import com.example.angularspring.entities.Client;
import com.example.angularspring.services.IClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClientController {
 
    @Autowired
    private IClientService clientService;

    private final Logger log = LoggerFactory.getLogger(ClientController.class);

    @GetMapping("/clients")
    public List<Client> index() {
        return clientService.findAll();
    }

    @GetMapping("/clients/page/{page}")
    public Page<Client> index(@PathVariable Integer page) {
        return clientService.findAll(PageRequest.of(page, 8));
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        Client client = null;
        Map<String, Object> response = new HashMap<>();
        try {
            client = clientService.findById(id);
        } catch (DataAccessException e) {
            response.put("msj", "An error occurred consulting the DB");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(client == null) {
            response.put("msj", "The client ID: ".concat(id.toString().concat(" wasn't found in the DB")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }

    @PostMapping("/clients")
    public ResponseEntity<?> create(@Valid @RequestBody Client client, BindingResult result) {
        Client createdClient = null;
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map( error -> "Field '" + error.getField() + "' " + error.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            createdClient = clientService.save(client);
        } catch (DataAccessException e) {
            response.put("msj", "An error occurred connecting the DB");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("msj", "The client: ".concat(client.getName().concat(" has been created successfully")));
        response.put("client", createdClient);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try{
            Client client = clientService.findById(id);
            String lastAvatar = client.getAvatar();
            if (lastAvatar != null && lastAvatar.length() > 0) {
                Path lastAvatarPath = Paths.get("uploads").resolve(lastAvatar).toAbsolutePath();
                File lastAvatarFile = lastAvatarPath.toFile();
                if(lastAvatarFile.exists() && lastAvatarFile.canRead()) {
                    lastAvatarFile.delete();
                }
            }
            clientService.delete(id);
        } catch (DataAccessException e) {
            response.put("msj", "An error occurred deleting item from the DB");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("msj", "The client has been deleted successfully");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Client client, BindingResult result, @PathVariable Long id) {
        Client currentClient = clientService.findById(id);
        Client updatedClient = null;
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map( error -> "Field '" + error.getField() + "' " + error.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        if(currentClient == null) {
            response.put("msj", "The client ID: ".concat(id.toString().concat(" wasn't found in the DB")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            currentClient.setName(client.getName());
            currentClient.setLastname(client.getLastname());
            currentClient.setEmail(client.getEmail());
            updatedClient = clientService.save(currentClient);
        } catch (DataAccessException e) {
            response.put("msj", "An error occurred updating the DB");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("msj", "The client: ".concat(client.getName().concat(" has been updated successfully")));
        response.put("client", updatedClient);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PostMapping("/clients/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        Client client = clientService.findById(id);
        if (!file.isEmpty()) {
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename().replace(" ", "");
            Path fileRoute = Paths.get("uploads").resolve(fileName).toAbsolutePath();
            log.info(fileRoute.toString());
            try {
                Files.copy(file.getInputStream(), fileRoute);
            } catch (IOException e) {
                response.put("msj", "An error occurred uploading the image");
                response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            String lastAvatar = client.getAvatar();
            if (lastAvatar != null && lastAvatar.length() > 0) {
                Path lastAvatarPath = Paths.get("uploads").resolve(lastAvatar).toAbsolutePath();
                File lastAvatarFile = lastAvatarPath.toFile();
                if(lastAvatarFile.exists() && lastAvatarFile.canRead()) {
                    lastAvatarFile.delete();
                }
            }
            client.setAvatar(fileName);
            clientService.save(client);
            response.put("client", client);
            response.put("msj", "The image has been uploaded successfully");
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/uploads/img/{fileName:.+}")
    public ResponseEntity<Resource> getAvatar(@PathVariable String fileName) {
        Path fileRoute = Paths.get("uploads").resolve(fileName).toAbsolutePath();
        log.info(fileRoute.toString());
        Resource resource = null;
        try {
            resource =  new UrlResource(fileRoute.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (!resource.exists() && !resource.isReadable()) {
            throw new RuntimeException("Error: The image file couldn't load correctly: " + fileName);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");
        return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
    }

}
