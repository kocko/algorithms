package hackerrank.contests.codewhiz;

import java.io.IOException;
import java.security.Permission;
import java.text.DecimalFormat;
import java.util.Scanner;

public class VolumeCalculator {

	static class Calculate {
	    static final double PI = Math.PI;

	    private Scanner sc;

	    Output output;

	    static class Output {
	        static double round(double value, int places) {
	            long factor = (long) Math.pow(10, places);
	            value = value * factor;
	            long tmp = Math.round(value);
	            return (double) tmp / factor;
	        }

	        void display(double result) throws IOException {
	            if (result == 0d) throw new IOException();
	            if (result < 0d) {
	                throw new NumberFormatException("All the values must be positive");
	            } else {
	                DecimalFormat df = new DecimalFormat("#0.000");
	                System.out.println(df.format(round(result, 3)));
	            }
	        }
	    }

	    static Calculate INSTANCE;

	    Calculate() {
	        sc = new Scanner(System.in);
	        output = new Output();
	        INSTANCE = this;
	    }

	    int ch = -2;

	    int getINTVal() throws IOException {
	    	try {
		        String line = sc.nextLine();
		        Double d = Double.parseDouble(line);
		        d = Output.round(d, 3);
		        if (ch < 0) ch++;
		        if (ch >= 0) {
		            ch = d.intValue();
		        }
		        
		        return ch >= 0 ? ch : d.intValue();
	    	} catch (NumberFormatException e) {
	    		throw new IOException(e);
	    	}
	    }

	    double getDoubleVal() throws IOException {
	    	try {
	    		Double d = Double.parseDouble(sc.nextLine());
	    		return Output.round(d, 3);
	    	} catch (NumberFormatException e) {
	    		throw new IOException(e);
	    	}
	    }

	    static Calculate get_Vol() {
	        return INSTANCE;
	    }

	    double main(double ... input) {
	        double result;
	        for (double i : input) {
	            if (i <= 0d) {
	                return -1d;
	            }
	        }
	        if (ch == 1) {
	            result = input[0] * input [0] * input [0];
	        } else if (ch == 2) {
	            double l = input[0];
	            double b = input[1];
	            double h = input[2];
	            result = l * b * h;
	        } else if (ch == 3) {
	            double r = input[0];
	            result = (2 * PI * r * r * r) / 3d;
	        } else {
	            double r = input[0];
	            double h = input[1];
	            result = PI * r * r * h;
	        }
	        return result;
	    }
	}

	public static void main(String[] args) {
		Do_Not_Terminate.forbidExit();
		try {
			Calculate cal = new Calculate();
			int T = cal.getINTVal();
			while (T-- > 0) {
				double volume = 0.0d;
				int ch = cal.getINTVal();
				if (ch == 1) {
					int a = cal.getINTVal();
					volume = Calculate.get_Vol().main(a);
				} else if (ch == 2) {

					int l = cal.getINTVal();
					int b = cal.getINTVal();
					int h = cal.getINTVal();
					volume = Calculate.get_Vol().main(l, b, h);

				} else if (ch == 3) {

					double r = cal.getDoubleVal();
					volume = Calculate.get_Vol().main(r);

				} else if (ch == 4) {

					double r = cal.getDoubleVal();
					double h = cal.getDoubleVal();
					volume = Calculate.get_Vol().main(r, h);

				}
				cal.output.display(volume);
			}

		} catch (NumberFormatException e) {
			System.out.print(e);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Do_Not_Terminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}
	}
}

class Do_Not_Terminate {

	public static class ExitTrappedException extends SecurityException {
		private static final long serialVersionUID = 1L;
	}

	public static void forbidExit() {
		final SecurityManager securityManager = new SecurityManager() {
			@Override
			public void checkPermission(Permission permission) {
				if (permission.getName().contains("exitVM")) {
					throw new ExitTrappedException();
				}
			}
		};
		System.setSecurityManager(securityManager);
	}
}

