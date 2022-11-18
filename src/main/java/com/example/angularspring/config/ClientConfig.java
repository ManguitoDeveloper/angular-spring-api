package com.example.angularspring.config;

import com.example.angularspring.entities.Client;
import com.example.angularspring.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class ClientConfig {

    @Bean
    CommandLineRunner commandLineRunner(ClientRepository repository) {
        return args -> {
            Client daniel = new Client(
                    "Daniel",
                    "Hernández",
                    "dahernansdez@intelix.biz"
            );
            Client antonio = new Client(
                    "Antonio",
                    "Pérez",
                    "mangoadobao@gmail.com"
            );
            Client hally = new Client(
                    "Hillary",
                    "Ruiz",
                    "hilydenos@gmail.com"
            );
            Client aleska = new Client(
                    "Aleska",
                    "Escudero",
                    "hilyoflove@gmail.com"
            );
            Client manguito = new Client(
                    "Manguito",
                    "Dev",
                    "freelancemanguito@gmail.com"
            );
            Client raul = new Client(
                    "Raul",
                    "Hernández",
                    "rhernandez@gmail.com"
            );
            Client yajaira = new Client(
                    "Detzy",
                    "Perez",
                    "detzyyajairap@gmail.com"
            );
            Client logan = new Client(
                    "Logan",
                    "Hernández",
                    "logancito@gmail.com"
            );
            Client rocky = new Client(
                    "Rocky",
                    "Hernández",
                    "rocky@gmail.com"
            );
            Client sanson = new Client(
                    "Sansón",
                    "Hernández",
                    "sanson@gmail.com"
            );
            Client berlina = new Client(
                    "Berlina",
                    "Ruiz",
                    "bruiz@gmail.com"
            );
            Client archie = new Client(
                    "Archie",
                    "Hernández",
                    "ardilla@gmail.com"
            );
            Client leroy = new Client(
                    "Leroy",
                    "Jenkins",
                    "leroyjenkins@gmail.com"
            );
            Client james = new Client(
                    "james",
                    "baXter",
                    "jamees@gmail.com"
            );
            Client dick = new Client(
                    "Dick",
                    "Grayson",
                    "nightwing@gmail.com"
            );
            Client bruce = new Client(
                    "Bruce",
                    "Wayne",
                    "batman@gmail.com"
            );
            Client tim = new Client(
                    "Timothy",
                    "drake",
                    "redRobin@gmail.com"
            );
            Client jason = new Client(
                    "Jason",
                    "Todd",
                    "redhood@gmail.com"
            );
            Client damian = new Client(
                    "Damian",
                    "Wayne",
                    "bolitadeodio@gmail.com"
            );
            Client clark = new Client(
                    "Clark",
                    "Kent",
                    "ckent@gmail.com"
            );
            Client raulito = new Client(
                    "raul",
                    "mendez",
                    "superman@gmail.com"
            );
            Client billy = new Client(
                    "Billy",
                    "Butcher",
                    "cunt@gmail.com"
            );
            Client hugh = new Client(
                    "Hugh",
                    "Campbell",
                    "hughie@gmail.com"
            );
            Client mm = new Client(
                    "Mother",
                    "Milk",
                    "mm@gmail.com"
            );
            Client luis = new Client(
                    "Luis",
                    "Molano",
                    "lmolano@gmail.com"
            );
            Client jack = new Client(
                    "Jack",
                    "Lopez",
                    "jlopez@gmail.com"
            );
            Client maria = new Client(
                    "Maria",
                    "Riera",
                    "mriera@intelix.biz"
            );
            Client temis = new Client(
                    "Temis",
                    "Barreto",
                    "tbarreto@intelix.biz"
            );
            Client marcel = new Client(
                    "Marcel",
                    "González",
                    "mgonzalez@intelix.biz"
            );
            Client jose = new Client(
                    "Jose",
                    "Quintero",
                    "jquintero@intelix.biz"
            );
            Client kike = new Client(
                    "kristhoffer",
                    "cortez",
                    "kcortez@intelix.biz"
            );
            Client jesus = new Client(
                    "jesus",
                    "malave",
                    "jmalave@intelix.biz"
            );
            Client yoel = new Client(
                    "yoel",
                    "moreno",
                    "ymoreno@intelix.biz"
            );
            Client rolman = new Client(
                    "rolman",
                    "parra",
                    "rparra@credix.cr"
            );
            Client freddy = new Client(
                    "freddy",
                    "salazar",
                    "fsalazar@intelix.biz"
            );
            Client genesis = new Client(
                    "genesis",
                    "marquez",
                    "gmarquez@intelix.biz"
            );
            Client mary = new Client(
                    "mary",
                    "giron",
                    "mgiron@intelix.biz"
            );
            Client mauricio = new Client(
                    "mauricio",
                    "leon",
                    "mleon@intelix.biz"
            );
            Client luisp = new Client(
                    "luis",
                    "porte",
                    "lporte@intelix.biz"
            );
            Client kira = new Client(
                    "light",
                    "yagami",
                    "lyagami@yahoo.com"
            );
            Client nicolas = new Client(
                    "nicolas",
                    "filizzola",
                    "nfiflizzola@yahoo.com"
            );
            Client naruto = new Client(
                    "Naruto",
                    "uzumaki",
                    "naruto@gmail.com"
            );
            Client sasuke = new Client(
                    "sasuke",
                    "uchiha",
                    "suchiha@gmail.com"
            );
            Client sakura = new Client(
                    "sakura",
                    "haruno",
                    "sakura@gmail.com"
            );
            Client lee = new Client(
                    "rock",
                    "lee-san",
                    "rlee@gmail.com"
            );
            Client shikamaru = new Client(
                    "shikamaru",
                    "nara",
                    "snara@gmail.com"
            );
            Client neji = new Client(
                    "neji",
                    "hyuga",
                    "byakugan@gmail.com"
            );
            Client hinata = new Client(
                    "hinata",
                    "hyuga",
                    "zzz@gmail.com"
            );
            Client kevin = new Client(
                    "kevin",
                    "powell",
                    "cssking@gmail.com"
            );
            Client gerard = new Client(
                    "gerard",
                    "way mcr",
                    "mcr@gmail.com"
            );
            Client napoleon = new Client(
                    "jose maria",
                    "napoleon",
                    "jmnapoleon@gmail.com"
            );
            Client shawn = new Client(
                    "shawn",
                    "mendez",
                    "smendez@gmail.com"
            );
            Client dove = new Client(
                    "dove",
                    "cameron",
                    "dcameron@gmail.com"
            );
            Client dante = new Client(
                    "dante",
                    "aligheri",
                    "notdmcdante@gmail.com"
            );
            Client alex = new Client(
                    "alex",
                    "ubago",
                    "aubago@gmail.com"
            );
            Client cristian = new Client(
                    "cristian",
                    "castro",
                    "ccastro@gmail.com"
            );
            Client michael = new Client(
                    "michael",
                    "jackson",
                    "mjackson@gmail.com"
            );
            Client evan = new Client(
                    "Evan",
                    "Vasiljevic",
                    "evasiljevic0@gmail.com"
            );
            Client stanton = new Client(
                    "Stanton",
                    "Ropkins",
                    "sropkins1@gmail.com"
            );
            Client krishna = new Client(
                    "Krishna",
                    "Boykett",
                    "kboykett2@gmail.com"
            );
            Client marquita = new Client(
                    "Marquita",
                    "Burberry",
                    "mburberry3@gmail.com"
            );
            Client rafaello = new Client(
                    "Rafaello",
                    "Jertz",
                    "rjertz4@gmail.com"
            );
            Client suzanne = new Client(
                    "Suzanne",
                    "Skirling",
                    "sskirling5@gmail.com"
            );
            Client bobbe = new Client(
                    "Bobbe",
                    "Patesel",
                    "bpatesel6@gmail.com"
            );
            Client lorena = new Client(
                    "Lorena",
                    "Atthow",
                    "latthow7@gmail.com"
            );
            Client priscella = new Client(
                    "Priscella",
                    "Mitford",
                    "pmitford8@gmail.com"
            );
            Client halsy = new Client(
                    "Halsy",
                    "Garside",
                    "hgarside9@gmail.com"
            );
            Client yoko = new Client(
                    "Yoko",
                    "Maunder",
                    "ymaundera@gmail.com"
            );
            Client jourdain = new Client(
                    "Jourdain",
                    "Bohling",
                    "jbohlingc@gmail.com"
            );
            Client phelia = new Client(
                    "Phelia",
                    "Jacqueminot",
                    "pjacqueminotb@gmail.com"
            );
            Client lola = new Client(
                    "Lola",
                    "Mollnar",
                    "lmollnare@gmail.com"
            );
            Client gian = new Client(
                    "Gian",
                    "Fritche",
                    "gfritchef@gmail.com"
            );
            repository.saveAll(
                    List.of(daniel,
                            antonio,
                            hally,
                            aleska,
                            manguito,
                            raul,
                            yajaira,
                            logan,
                            rocky,
                            sanson,
                            berlina,
                            archie,
                            leroy,
                            james,
                            dick,
                            bruce,
                            tim,
                            jason,
                            damian,
                            clark,
                            raulito,
                            billy,
                            hugh,
                            mm,
                            luis,
                            jack,
                            maria,
                            jose,
                            temis,
                            marcel,
                            kike,
                            jesus,
                            yoel,
                            rolman,
                            freddy,
                            genesis,
                            mary,
                            mauricio,
                            luisp,
                            kira,
                            nicolas,
                            naruto,
                            sasuke,
                            sakura,
                            lee,
                            shikamaru,
                            neji,
                            hinata,
                            kevin,
                            gerard,
                            napoleon,
                            shawn,
                            dove,
                            dante,
                            alex,
                            cristian,
                            michael,
                            evan,
                            stanton,
                            krishna,
                            marquita,
                            rafaello,
                            suzanne,
                            bobbe,
                            lorena,
                            priscella,
                            halsy,
                            yoko,
                            phelia,
                            jourdain,
                            lola,
                            gian
                    )
            );
        };
    };
}
