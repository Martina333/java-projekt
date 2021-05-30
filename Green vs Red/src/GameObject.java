public abstract class GameObject {
	private int x, y;

	protected GameObject(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	protected void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}
}