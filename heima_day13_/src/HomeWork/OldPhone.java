package HomeWork;

public class OldPhone {
	public static void main(String[] args) {
		new Phone() {

			@Override
			public void call() {
			}

			@Override
			public void sendMsg() {
			}

			public void playGame() {
				System.out.println("玩游戏");
			}
		}.playGame();
	}
}
