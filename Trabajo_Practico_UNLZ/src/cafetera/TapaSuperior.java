package cafetera;

public class TapaSuperior {
	// representa si tapa el orificio de una cafetera
	private boolean destapado;

	/**
	 * comienza tapando el orificio de la cafetera cuando se coloca la tapa
	 *
	 * @param estaTapando
	 */
	public TapaSuperior() {
		this.destapado = false;
	}

	/**
	 * @return the destapado
	 */

	public boolean isDestapado() {
		return destapado;
	}

	/**
	 * @param destapado the destapado to set
	 */
	public void setDestapado(boolean destapado) {
		this.destapado = destapado;
	}
}
