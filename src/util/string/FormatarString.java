package util.string;

public final class FormatarString {
	
	/**
	 * Metodo remove todos os espaços duplicados, no começo, fim e meio da frase.
	 * 
     * @param   string
     *          Frase a ter os espaços removidos
     *
     * @return  {@code String}
     * 			Frase com seus espaços removidos
     *
     * 
     */
	public static String removerEspacosDuplicados(String string){
		return string.trim().replaceAll(" +", " ");
	}
	
	public static String removerMascara(String string){
		string = string.replace("(", "");
		string = string.replace(")", "");
		string = string.replace("-", "");
		string = string.replace(" ", "");
		return string;
	}

}
