import java.lang.Math;

class NumberSystemConversion {

    public int binaryToDecimal(String binary) {
        int dec = 0;
        int pow = binary.length() - 1;
        // this is to verify binary string
        try {
            String bin_s = "01";
            for (int n = 0; n < binary.length(); n++) {
                char z = binary.charAt(n);
                if (!bin_s.contains(String.valueOf(z))) {
                    throw new Exception("Binary String is not valid");
                }
            }

        } catch (Exception e) {
            return -2;
        }

        for (int n = 0; n < binary.length(); n++) {
            char z = binary.charAt(n);
            int int_z = Integer.parseInt(String.valueOf(z));
            dec += (int_z * (Math.pow(2, pow)));
            pow--;
        }

        return dec;

    }

    public double octalToDecimal(String octal) {
        double dec = 0;
        int pow = octal.length() - 1;
        // this is to verify octal string
        try {
            String octalet = "01234567";
            for (int n = 0; n < octal.length(); n++) {
                char z = octal.charAt(n);
                if (!octalet.contains(String.valueOf(z))) {
                    throw new Exception("Octal String is not valid");
                }
            }

        } catch (Exception e) {
            return -8;
        }
        for (int n = 0; n < octal.length(); n++) {
            char z = octal.charAt(n);
            int int_z = Integer.parseInt(String.valueOf(z));
            dec += (int_z * (Math.pow(8, pow)));
            pow--;
        }

        return dec;
    }

    public double hexaDecimalToDecimal(String hex) {
        double dec = 0;
        int pow = hex.length() - 1;

        // this is to verify hex string
        try {
            String hexel = "0123456789ABCDEFabcdef";
            for (int n = 0; n < hex.length(); n++) {
                char z = hex.charAt(n);
                if (!hexel.contains(String.valueOf(z))) {
                    throw new Exception("HexaDecimal String is not valid");
                }
            }

        } catch (Exception e) {
            return -16;
        }

        for (int n = 0; n < hex.length(); n++) {
            char z = hex.charAt(n);
            int int_z = 0;
            if ("A".equalsIgnoreCase(String.valueOf(z))) {
                int_z = 10;
            } else if ("B".equalsIgnoreCase(String.valueOf(z))) {
                int_z = 11;
            }

            else if ("C".equalsIgnoreCase(String.valueOf(z))) {
                int_z = 12;
            }

            else if ("D".equalsIgnoreCase(String.valueOf(z))) {
                int_z = 13;
            }

            else if ("E".equalsIgnoreCase(String.valueOf(z))) {
                int_z = 14;
            }

            else if ("F".equalsIgnoreCase(String.valueOf(z))) {
                int_z = 15;
            }

            else {
                int_z = Integer.parseInt(String.valueOf(z));
            }

            dec += (int_z * (Math.pow(16, pow)));
            pow--;
        }

        return dec;
    }

    /**Decimals smaller than Zero won't be converted */
    public String decimalToBinary(int dec) {
        String binary = "";
        try{
            if (dec<0){
                throw new Exception("Value smaller than Zero");
            }
        }catch(Exception e){
            return e.getMessage();
        }
        while (dec > 1) {
            int r = dec % 2;
            binary = binary + String.valueOf(r);
            dec = dec / 2;
        }
        binary = binary + String.valueOf(dec);
        StringBuilder str_b = new StringBuilder();
        str_b.append(binary);
        str_b.reverse();

        return str_b.toString();
    }

    public String decimalToOctal(int dec) {
        String octal = "";

        try {
            if (dec < 0) {
                throw new Exception("Value smaller than Zero");
            }
        } catch (Exception e) {
            return e.getMessage();
        }
        while (dec > 7) {
            int r = dec % 8;
            octal = octal + String.valueOf(r);
            dec = dec / 8;
        }
        octal = octal + String.valueOf(dec);
        StringBuilder str_b = new StringBuilder();
        str_b.append(octal);
        str_b.reverse();

        return str_b.toString();
    }

    public String decimalToHexaDecimal(int dec) {
        String hex = "";
        try {
            if (dec < 0) {
                throw new Exception("Value smaller than Zero");
            }
        } catch (Exception e) {
            return e.getMessage();
        }
        while (dec > 15) {
            int r = dec % 16;
            if (r == 11) {
                hex = hex + "B";
            } else if (r == 10) {
                hex = hex + "A";
            } else if (r == 13) {
                hex = hex + "D";
            } else if (r == 12) {
                hex = hex + "C";
            } else if (r == 15) {
                hex = hex + "F";
            } else if (r == 14) {
                hex = hex + "E";
            } else {
                hex = hex + String.valueOf(r);
            }

            dec = dec / 16;
        }
        if (dec == 13) {
            hex = hex + "D";
        } else if (dec == 12) {
            hex = hex + "C";
        } else if (dec == 15) {
            hex = hex + "F";
        } else if (dec == 11) {
            hex = hex + "B";
        } else if (dec == 10) {
            hex = hex + "A";
        } else if (dec == 14) {
            hex = hex + "E";
        }else {
            hex = hex + String.valueOf(dec);
        }
        StringBuilder str_b = new StringBuilder();
        str_b.append(hex);
        str_b.reverse();

        return str_b.toString();

    }
}
