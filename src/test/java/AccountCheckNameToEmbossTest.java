import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import io.qameta.allure.junit4.DisplayName;

@RunWith(Parameterized.class)
public class AccountCheckNameToEmbossTest {

    private final String nameAndLastname;
    private final boolean expected;

    public AccountCheckNameToEmbossTest(String nameAndLastname, boolean expected) {
        this.nameAndLastname = nameAndLastname;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: {0}")
    public static Object[] checkNameToEmbossTest() {
        return new Object[][]{
                {"Тимоти Шаламе", true},
                {" Тимоти Шаламе ", false},
                {"Тимоти Шаламе ", false},
                {" Тимоти Шаламе", false},
                {"ТимотиШаламе", false},
                {"Т Ш", true},
                {"Т ", false},
                {"Тимоти Шаламеeeeeee", true},
                {"Тимоти Шаламеeeeeeee", false},
                {"", false},
                {null, false},
        };
    }

    @Test
    @DisplayName("Проверка эмбосссирования")
    public void checkNameToEmboss() {
        Account account = new Account(nameAndLastname);
        assertEquals("Имя и фамилия не прошли валидационные правила", expected, account.checkNameToEmboss());

    }

}