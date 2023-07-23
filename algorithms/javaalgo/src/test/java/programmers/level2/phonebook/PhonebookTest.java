package programmers.level2.phonebook;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class PhonebookTest {

    @Test
    void test() {
        String[] phonebook1 = {"119", "97674223", "1195524421"};
        String[] phonebook2 = {"123", "456", "789"};
        String[] phonebook3 = {"12", "123", "1235", "567", "88"};

        assertAll(
            () -> assertThat(solution(phonebook1)).isFalse(),
            () -> assertThat(solution(phonebook2)).isTrue(),
            () -> assertThat(solution(phonebook3)).isFalse()
        );
    }

    public boolean solution(String[] phonebook) {
        Arrays.sort(phonebook);
        for (int i = 0; i < phonebook.length - 1; i++) {
            if (phonebook[i + 1].startsWith(phonebook[i])) {
                return false;
            }
        }
        return true;
    }
}
