import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void checkWhenFirstPlayerStronger() {
        Game game = new Game();

        Player player1 = new Player(111, "Moon", 250);
        Player player2 = new Player(222, "Star", 200);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Moon", "Star");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void checkWhenTheSecondPlayerStronger() {
        Game game = new Game();

        Player player1 = new Player(111, "Moon", 250);
        Player player2 = new Player(222, "Star", 2000);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Moon", "Star");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkWhenStrengthBothPlayersEqual() {
        Game game = new Game();

        Player player1 = new Player(111, "Moon", 250);
        Player player2 = new Player(222, "Star", 250);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Moon", "Star");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void checkWhenTheSecondPlayerDoesNotExist() {
        Game game = new Game();

        Player player1 = new Player(111, "Moon", 250);
        Player player2 = new Player(222, "Star", 200);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Moon", "Sun")
        );

    }

    @Test
    public void checkWhenTheFirstPlayerDoesNotExist() {
        Game game = new Game();

        Player player1 = new Player(111, "Moon", 250);
        Player player2 = new Player(222, "Star", 200);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Planet", "Star")
        );

    }

    @Test
    public void checkWhenBothPlayerDoesNotExist() {
        Game game = new Game();

        Player player1 = new Player(111, "Moon", 250);
        Player player2 = new Player(222, "Star", 200);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Planet", "Sun")
        );

    }
}
