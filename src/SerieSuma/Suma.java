package SerieSuma;

public class Suma {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero1 = 0;
		int numero2 = 1;
		int suma = 0;
		int cantidadNumeros = 10;
		
		for (int x = 0; x<=cantidadNumeros ; x++ ) {
			suma = numero1 + numero2;
			numero1 = numero2;
			numero2 = suma;

			System.out.println(suma);
	}
	}
}
