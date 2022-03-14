public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
        if (name.length() >= 3 &&
                name.length() <= 19 &&
                   name.endsWith(" ") == false &&
                       name.startsWith(" ") == false &&
                           checkAvailabilitySpace()){
            return true;
        } else return false;
    }

    public boolean checkAvailabilitySpace () {
        char[] chArray = name.toCharArray();
        int spaceCount = 0;
        for (int i = 0; i < chArray.length; i++) {
            if (chArray[i] == ' ') {
                spaceCount = spaceCount + 1;
            }
        }

        if (spaceCount <= 1 && spaceCount >= 1){
            return true;
        } else return false;
    }

}