import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;


        public class PainokerroinOhjelma {
        private  static int paino;
        private  static double pituus;


            public static void main(String[] args) {

            boolean painoOikea = false;
            boolean pituusOikea = false;

            do {
                try {


                    kysyPaino();
                    painoOikea = true;

                } catch (Exception e){
                    System.out.println(e.getMessage());


                }
            } while (!painoOikea);


            do {
                try {


                    kysyPituus();
                    pituusOikea = true;
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            } while (!pituusOikea);

            tulostaPainokerroin();


            }

            public static void kysyPaino() throws KelvotonPainoPoikkeus {
                Scanner input = new Scanner(System.in);
                System.out.print("Anna paino (kg): ");


                try {
                  paino = input.nextInt();
                  if (paino < 0)
                      throw new Exception();


                } catch (InputMismatchException e) {
                    throw new KelvotonPainoPoikkeus("Painon pitää olla kokonaisluku");
                }
                catch (Exception e){
                    throw new KelvotonPainoPoikkeus("Paino pitää olla >0");
                }
                finally {
                    input.nextLine();
                }



            }

            public static void kysyPituus() throws KelvotonPituusPoikkeus {
                Scanner input = new Scanner(System.in);
                System.out.print("Anna pituus (m): ");


                try {
                    pituus = input.nextDouble();
                    if (pituus <= 0 || pituus > 3)
                        throw new Exception();
                }
                catch (InputMismatchException e){
                    throw new KelvotonPituusPoikkeus("Pituus pitää olla desimaaliluku");
                }
                catch (Exception e){
                    throw new KelvotonPituusPoikkeus("Ihmisen pituus pitää olla > 0 ja alle 3 metriä");
                }
               finally {
                    System.out.println();
                }

            }
            public static void tulostaPainokerroin(){
                DecimalFormat desi = new DecimalFormat("0.00");
                System.out.println("Painokerroin on " +desi.format(paino / (pituus * pituus))+ " (kun paino on " + paino + " kg ja pituus on " + desi.format(pituus) + " metrinä");

            }

            }












