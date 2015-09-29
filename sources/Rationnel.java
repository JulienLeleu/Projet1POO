class Rationnel {

	private int n;
	private int a;
	private int b;

    /**
     * Constructeur de la classe Rationnel
     *
     *@param : n la partie entière
     *@param : a le numerateur de la partie décimale
     *@param : b le dénominateur de la partie décimale
     */
	public Rationnel(int n, int a, int b) {
		this.n = n;
		this.a = a;
		this.b = b;
		this.modif();
	}

    /**
     * Constructeur de la classe Rationnel
     *
     *@param : a le numerateur de la partie décimale
     *@param : b le dénominateur de la partie décimale
     */
	public Rationnel(int a, int b) {
		this.a = a;
		this.b = b;
	        this.modif();
	}

     /**
     * Constructeur de la classe Rationnel
     *
     *@param : n la partie entière
     */
	public Rationnel(int n) {
		this.n = n;
	        this.modif();
	}

    /**
     * renvoie true si le nombre rationnel vaut 0 sinon renvoie false
     */
	public boolean estNul() {
		return n*b + a == 0;
	}

    /**
     * renvoie l'inverse du nombre rationnel
     */
	public Rationnel inverse() {
	    return new Rationnel(b,n*b+a) ;
	}

    /**
     * Permet d'additioner au nombre rationnel courant un autre nombre rationnel 
     *@param : r Le nombre rationnel à ajouter
     */
	public Rationnel ajouter(Rationnel r) {
	    int nResult = this.n + r.getN();
	    int aResult = this.a*r.getB() + r.getA()*this.b;
	    int bResult = this.b * r.getB();
	    return new Rationnel (nResult,aResult,bResult);
	}

    /**
     * Permet de multiplier au nombre rationnel courant un autre nombre rationnel 
     *@param : r Le nombre rationnel par lequel on va le multiplier
     */
	public Rationnel multiplier(Rationnel r) {
	    int nResult = this.n*r.getN();
	    int aResult = r.getA()*this.n*this.b + r.getB()*this.a*this.n + r.getA()*this.a;
	    int bResult = r.getB()*this.b;
	    return new Rationnel (nResult,aResult,bResult);
	}

    /**
     * Renvoie une représentation sous forme de chaîne de caractères, le nombre rationnel
     */
	public String toString() {
	    if (a==0 && b==0)
		return n+" + 0";
	    else if (a==0)
		return n+"";
	    else if (n==0)
		return a+"/"+b;
	    else
	        return n+" + "+a+"/"+b;
	    }

    /**
     * Compare deux nombre rationnel et retourne la différence entre les deux
     */
	public int compare(Rationnel r) {
	    int numA = (this.n*this.b + this.a) * r.getB();
	    int numA2 = (r.getN()*r.getB() + r.getA()) * this.b;
	    return  numA-numA2;
	}

    /**
     * Cette méthode normalise le nombre rationnel
     */
	public void  modif() {
	    // -28/16; a=-28; b=16; n=0;
	    if (this.a<0 ^ this.b<0 || this.a>this.b) {
		if(this.b<0) {
		    this.a = -this.a;
		    this.b = -this.b;
		}
		//a=-28; b=16; n=0;
		int nTmp = this.a/this.b;
		//nTmp=-1;
		this.n += nTmp;
		//n=-1;
		this.a=this.a-nTmp*this.b;
		//a=-12;b=16;n=-1;
		if (a<0) {
		    this.a=this.b+this.a;
		    //a=4;b=16;n=-1;
		    this.n--;
		    //n=-2;
		}	   	         
	    }
	    if (pgcd(a,b)!=1 && pgcd(a,b)!=0) { //simplification
		int pgcd = pgcd(a,b);
		this.a = a/pgcd;
		this.b = b/pgcd;
	    }

	}

	public Rationnel getPartieEntiere () {
	    return new Rationnel(this.n);
	}

	public Rationnel getPartieDecimale() {
	    return new Rationnel(this.a,this.b);
	}

    /**
     * Calcul le PGCD entre deux nombre : a et b
     *@param : a le premier nombre
     *@param : b le deuxieme nombre
     */
	public static int pgcd(int a,int b) {
	    int r;
	    while(b!=0) {
		r=a%b;
		a=b;
		b=r;
	    }
	    return a;
	}

	public int getA(){
	    return this.a;
	}

	public int getB(){
	    return this.b;
	}

	public int getN(){
	    return this.n;
	}

	public static void main(String[] args){
	    Rationnel ratio = new Rationnel(1,2);
	    System.out.println("get Partie Entiere : "+ratio.getPartieEntiere());
	    System.out.println("get Partie Decimale : "+ratio.getPartieDecimale());
	    /* System.out.println(new Rationnel(0,0,15).estNul());
	    System.out.println(new Rationnel(4,2,15).estNul());
	    System.out.println("inverse " +ratio.inverse());
	    System.out.println("ajouter " + ratio.ajouter(ratio));
	    System.out.println("multiplier " + ratio.multiplier(ratio));
	    System.out.println("compare " + new Rationnel(1,2,3).compare(ratio));*/
	    System.out.println("test 1 : "+new Rationnel(3,4,5));
	    System.out.println("test 2 : "+new Rationnel(5,4,3));
	    System.out.println("test 3 : "+new Rationnel(-2,3));
	    System.out.println("test 4 : "+new Rationnel(3,-2));
	    System.out.println("test 5 : "+new Rationnel(0,1));
	    System.out.println("test 6 : "+new Rationnel(-90,17));
	    System.out.println("test 7 : "+new Rationnel(28,-16));
	}
}
	
