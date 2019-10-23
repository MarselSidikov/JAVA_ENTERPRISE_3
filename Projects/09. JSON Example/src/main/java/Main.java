import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Main {
    public static void main(String[] args) throws Exception {
        AuthData authData = new AuthData();
        authData.setEmail("sidikov.marsel@gmail.com");
        authData.setPassword("qwerty007");

        User user = new User();
        user.setFirstName("Марсель");
        user.setLastName("Сидиков");
        user.setAge(25);
        user.setAuthData(authData);

        List<Integer> marks = new ArrayList<Integer>();
        marks.add(90);
        marks.add(90);
        marks.add(85);

        user.setMarks(marks);

        ObjectMapper mapper = new ObjectMapper();

        String jsonValue = mapper.writeValueAsString(user);

        System.out.println(jsonValue);

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "qwerty007";
        String hash = encoder.encode(password);
        System.out.println(hash);
        System.out.println(encoder.matches("qwerty008", hash));
    }
}
