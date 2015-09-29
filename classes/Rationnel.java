class Rationnel {

	private int n;
	private int a;
	private int b;
	
	public Rationnel(int n, int a, int b) {
		this.n = n;
		this.a = a;
		this.b = b;
	}
	
	public Rationnel(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public Rationnel(int n) {
		this.n = n;
	}
	
	public boolean estNul() {
		return (n + a/b) == 0;
	}
	
	public Rationnel inverse() {
		return new Rationnel(1/n, b, a);
	}
	
	public Rationnel ajouter(Rationnel r) {
		return new Rationnel(
	}
	
	public Rationnel multiplier(Rationnel r) {
		
	}
	
