package br.com.waiso.utils;


public class StringUtils {

	public static boolean isBlank(String obj) {
		return (obj == null || obj.equals("") || obj.equals("null") || obj.trim().equals(""));
	}	
	
	public static String leftPad(String str, String character, int size){
		if (str != null){
			int delta = size - str.length();
			for(int i = 0; i < delta; i++){
				str = character + str;
			}
		}
		return str;
	}
	
	public static boolean isOnlyNumber(String str){
		boolean ret = false;
		if (str != null){
			ret = str.matches("^[0-9]+$");
		}
		return ret;
	}

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
	
    public static String toValidCPF(String identificacao){
    	String newValue = null;
    	if(!isBlank(identificacao)){
    		String cpf_1 = identificacao.substring(0, 3);
    		String cpf_2 = identificacao.substring(3, 6);
    		String cpf_3 = identificacao.substring(6, 9);
    		String cpf_4 = identificacao.substring(9);
    		newValue = cpf_1 + "." + cpf_2 + "." + cpf_3 + "-" + cpf_4;
    	}
    	return newValue;
    }

    public static String toValidCNPJ(String identificacao){
    	String newValue = null;
    	if(!isBlank(identificacao)){
    		String cnpj_1 = identificacao.substring(0, 2);
    		String cnpj_2 = identificacao.substring(2, 5);
    		String cnpj_3 = identificacao.substring(5, 8);
    		String cnpj_4 = identificacao.substring(8, 12);
    		String cnpj_5 = identificacao.substring(12);
    		newValue = cnpj_1 + "." + cnpj_2 + "." + cnpj_3 + "/" + cnpj_4 + "-" + cnpj_5;
    	}
    	return newValue;
    }
}