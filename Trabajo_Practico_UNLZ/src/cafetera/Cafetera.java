package cafetera;

/*
* Representa el comportamiento de una cafetera
  */
public class Cafetera {

	private int capacidadMaxima = 1000;
	private int cantidadActual = 0;
	private TapaSuperior tapa;

	// constructores
	// constructor que determina una capacidad maxima y una cantidad actual del
	// contenido vacio
	public Cafetera(TapaSuperior destapado) {
	
	}

	// constructor con la capacidad maxima de la cafetera
	public Cafetera(int capacidadMaxima, TapaSuperior destapado) {
		this.capacidadMaxima = capacidadMaxima;
		this.cantidadActual = capacidadMaxima;
		this.tapa = destapado;
	}

	// constructor comparando si la cantidad actual de la cafetera es mayor a la
	// capacidad maxima
	public Cafetera(int capacidadMaxima, int cantidadActual, TapaSuperior destapado) {
		if (cantidadActual > capacidadMaxima) {
			this.capacidadMaxima = capacidadMaxima;
			this.cantidadActual = capacidadMaxima;
			this.tapa = destapado;
		} else {
			this.cantidadActual = cantidadActual;
			this.capacidadMaxima = capacidadMaxima;
			this.tapa = destapado;
		}
	}

	// getters y setters
	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	public int getCantidadActual() {
		return cantidadActual;
	}

	public void setCantidadActual(int cantidadActual) {
		this.cantidadActual = cantidadActual;
	}

	public TapaSuperior getTapa() {
		return tapa;
	}

	public void setTapa(TapaSuperior tapa) {
		this.tapa = tapa;
	}

	// metodos
	public void llenarCafetera(TapaSuperior tapa) { 
		
		if (!tapa.isDestapado()) {
			System.out.println("Abra la tapa para poder cargar.\\n");
		} else {
			if (cantidadActual >= 0 && cantidadActual < capacidadMaxima) {
				cantidadActual = capacidadMaxima;
				System.out.println("La cafetera se lleno exitosamente: "+ this.capacidadMaxima + " cc.\n");
			} else {
				System.out.println("La cafetera ya se encuentra en su capacidad maxima: " + this.capacidadMaxima + " cc.\\n");
			}
		}
	}

	public void servirTaza(int capacidadTaza, TapaSuperior tapa) {
		if (tapa.isDestapado()) {
			System.out.println("Cierre la tapa para poder servir.\n");
		}else {
			if (capacidadTaza > cantidadActual) {
			cantidadActual = 0;
			System.out.println("La cafetera ha quedado vacia: "+ this.capacidadMaxima + " cc.\n");
			} else {
				cantidadActual = cantidadActual - capacidadTaza;
				System.out.println("Se sirvio una taza con un contenido de: "+ capacidadTaza + " cc.\n");
				System.out.println("La cafetera quedo con un contenido de: " + this.cantidadActual + " cc.\n");
			}
		}
		
	}

	public void vaciarCafetera(TapaSuperior tapa) {
		if (tapa.isDestapado()) {
			System.out.println("Por favor cierre la tapa para vaciar la cafetera.\n");
		}else {
			cantidadActual = 0;
			System.out.println("La cafetera se ha vaciado correctamente: "+ this.cantidadActual + " cc.\n");
		}
		
	}

	public void agregarCafe(int cantidadCafe, TapaSuperior tapa) {
		// validando si la tapa esta cerrada.
		if (tapa.isDestapado()) {
			System.out.println("Abra la tapa para poder agreagar cafe.\n");
		} else {
			// si la tapa esta abierta, validamos la cantidad de cafe a ingresar.
			if (cantidadActual == capacidadMaxima) {
				System.out.println("La cafetera ya se encuentra llena.\n");
			} else if (cantidadCafe > 0 && cantidadActual + cantidadCafe <= capacidadMaxima) {
				cantidadActual += cantidadCafe;
				System.out.println("La cantidad actual de cafe es: " + cantidadActual + " cc.\n");
			} else if (cantidadCafe > 0 && cantidadActual + cantidadCafe >= capacidadMaxima) {
				int restante = this.capacidadMaxima - this.cantidadActual;
				System.out.println(
						"La cafetera se rebalzara si agrega esa cantidad de cafe, por favor agregue el contenido necesario: "
								+ restante + " cc.\n");
			}
		}

	}

	public void cargarDesdeOtraCafetera(Cafetera unaCafetera, TapaSuperior tapa) {
		// comparo que no sea la mismma cafetera
		if (validarCarga(unaCafetera)) {

			// verifico que mi cafetera no se encuentre con su capacidad maxima
			if (this.cantidadActual == this.capacidadMaxima) {

				// calculo la carga total que tendra mi cafetera al ser cargada
				int cargaTotal = this.cantidadActual + unaCafetera.getCantidadActual();
				if (cargaTotal <= this.capacidadMaxima) {
					this.cantidadActual += unaCafetera.getCantidadActual();
					unaCafetera.setCantidadActual(0);
					System.out.println("La cantidad actual de la cafetera es de: " + cargaTotal + " cc.\n");
				} else if (cargaTotal > this.capacidadMaxima) {
					int restante = cargaTotal - this.capacidadMaxima;
					unaCafetera.setCantidadActual(restante);
					System.out.println(
							"La cafetera se rebalzara si agrega esa cantidad de cafe, por favor agregue el contenido necesario: "
									+ this.capacidadMaxima + " cc.\n");
				}

			} else {
				System.out.println("La cafetera ya se encuentra completa: " + this.cantidadActual + " cc.\n");
			}

		} else {
			System.out.println("son las mismas cafeteras, ingrese otra cafetera.\n");
		}
	}

	public boolean validarCarga(Cafetera unaCafetera) {
		return !this.equals(unaCafetera) && this.cantidadActual < this.capacidadMaxima;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cafetera other = (Cafetera) obj;
		if (cantidadActual != other.cantidadActual)
			return false;
		if (capacidadMaxima != other.capacidadMaxima)
			return false;
		if (tapa == null) {
			if (other.tapa != null)
				return false;
		} else if (!tapa.equals(other.tapa))
			return false;
		return true;
	}
	
	

}
