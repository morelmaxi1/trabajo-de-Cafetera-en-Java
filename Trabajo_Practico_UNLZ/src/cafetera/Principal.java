package cafetera;

public class Principal {
	
	public static void main(String[] args) {
		TapaSuperior tapaCafetera = new TapaSuperior();
		
		System.out.println(tapaCafetera.isDestapado());

		Cafetera c1 = new Cafetera(tapaCafetera);
		Cafetera c2 = new Cafetera(1000, tapaCafetera);
		
		c2.servirTaza(300, tapaCafetera);
		System.out.println("c2: "+c2.getCantidadActual());

		System.out.println( "c1: " + c1.getCantidadActual());
		
		c1.llenarCafetera(tapaCafetera);
		
		tapaCafetera.setDestapado(true);
		
		System.out.println(tapaCafetera.isDestapado());
		
		c1.llenarCafetera(tapaCafetera);
		
		c1.servirTaza(350, tapaCafetera);
		
		tapaCafetera.setDestapado(false);
		
		c1.servirTaza(350, tapaCafetera);
		
		System.out.println("Estado de la tapa:" + tapaCafetera.isDestapado());
		
		c1.vaciarCafetera(tapaCafetera);
			
		c1.agregarCafe(500, tapaCafetera);
		
		//c1.agregarCafe(400, tapaCafetera);
		
		//c1.agregarCafe(400, tapaCafetera);
		
		//c1.agregarCafe(100, tapaCafetera);

		c1.cargarDesdeOtraCafetera(c2, tapaCafetera);
		
		System.out.println("c2: "+c2.getCantidadActual());
		System.out.println( "c1: " + c1.getCantidadActual());
	

	}

}
