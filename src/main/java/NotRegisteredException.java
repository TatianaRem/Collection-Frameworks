public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException(String playerName) {
        super("Игрок с таким именем " + playerName + " не зарегестрирован");
    }
}
