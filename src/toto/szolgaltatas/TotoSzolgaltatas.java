package toto.szolgaltatas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import toto.tarolo.Eredmeny;
import toto.tarolo.Fordulo;
import toto.tarolo.Talalat;

public class TotoSzolgaltatas {
    private static final String totoFileSrc = "D:\\NetBeans programok\\toto\\toto.csv";
    private static final String COMMA_DELIMITER = ";";
    private List<Fordulo> forduloList;
    private int _1 = 0;
    private int _2 = 0;
    private int _x = 0;
    private int legmagasabNyeremeny = 0;
    int lineIndex = 1;

    public TotoSzolgaltatas() {
        try {
            this.forduloList = new ArrayList();
            BufferedReader br = new BufferedReader(new FileReader("D:\\NetBeans programok\\toto\\toto.csv"));

            String line;
            try {
                while((line = br.readLine()) != null) {
                    String[] values = line.split(";");
                    Fordulo fordulo = new Fordulo();
                    fordulo.setEv(this.getStringAsInt(values[0]));
                    fordulo.setHet(this.getStringAsInt(values[1], 1));
                    fordulo.setForduloAHeten(this.getStringAsInt(values[2], 1));
                    if (!values[3].isEmpty()) {
                        fordulo.setDatum(LocalDate.parse(values[3], DateTimeFormatter.ofPattern("yyyy.MM.dd.")));
                    } else {
                        Calendar cal = Calendar.getInstance();
                        cal.set(1, fordulo.getEv());
                        cal.set(3, fordulo.getHet());
                        cal.set(7, fordulo.getForduloAHeten());
                        fordulo.setDatum(LocalDate.of(fordulo.getEv(), cal.get(2) + 1, cal.get(7)));
                    }

                    fordulo.addTalalat(new Talalat(this.getStringAsInt(values[4]), this.getStringAsInt(values[4]), this.getStringAsInt(values[5])));
                    fordulo.addTalalat(new Talalat(this.getStringAsInt(values[6]), this.getStringAsInt(values[6]), this.getStringAsInt(values[7])));
                    fordulo.addTalalat(new Talalat(this.getStringAsInt(values[8]), this.getStringAsInt(values[8]), this.getStringAsInt(values[9])));
                    fordulo.addTalalat(new Talalat(this.getStringAsInt(values[10]), this.getStringAsInt(values[10]), this.getStringAsInt(values[11])));
                    fordulo.addTalalat(new Talalat(this.getStringAsInt(values[12]), this.getStringAsInt(values[12]), this.getStringAsInt(values[13])));
                    if (this.legmagasabNyeremeny < this.getStringAsInt(values[5])) {
                        this.legmagasabNyeremeny = this.getStringAsInt(values[5]);
                    } else if (this.legmagasabNyeremeny < this.getStringAsInt(values[7])) {
                        this.legmagasabNyeremeny = this.getStringAsInt(values[7]);
                    } else if (this.legmagasabNyeremeny < this.getStringAsInt(values[9])) {
                        this.legmagasabNyeremeny = this.getStringAsInt(values[9]);
                    } else if (this.legmagasabNyeremeny < this.getStringAsInt(values[11])) {
                        this.legmagasabNyeremeny = this.getStringAsInt(values[11]);
                    } else if (this.legmagasabNyeremeny < this.getStringAsInt(values[13])) {
                        this.legmagasabNyeremeny = this.getStringAsInt(values[13]);
                    }

                    for(int index = 14; index < values.length; ++index) {
                        String clearVal = values[index].replaceAll("[^xX1-2]", "");
                        Eredmeny eredmeny = Eredmeny.valueOf("_" + clearVal.toUpperCase());
                        fordulo.addEredmeny(eredmeny);
                        if (eredmeny == Eredmeny._1) {
                            ++this._1;
                        } else if (eredmeny == Eredmeny._2) {
                            ++this._2;
                        } else if (eredmeny == Eredmeny._X) {
                            ++this._x;
                        }
                    }

                    this.forduloList.add(fordulo);
                    ++this.lineIndex;
                }
            } catch (Throwable var9) {
                try {
                    br.close();
                } catch (Throwable var8) {
                    var9.addSuppressed(var8);
                }

                throw var9;
            }

            br.close();
        } catch (Exception var10) {
            int var10001 = this.lineIndex;
            System.out.println(var10001 + ": " + var10.getMessage());
            System.out.println("Hiba történt a file beolvasásakor.");
        }

    }

    public List<Fordulo> getForduloList() {
        return this.forduloList;
    }

    private int getStringAsInt(String value) {
        return this.getStringAsInt(value, 0);
    }

    private int getStringAsInt(String value, int def) {
        boolean var3 = false;

        int t;
        try {
            t = Integer.parseInt(value.replaceAll("[^\\d]", ""));
        } catch (Throwable var5) {
            t = def;
        }

        return t;
    }

    public int getLegmagasabNyeremeny() {
        return this.legmagasabNyeremeny;
    }

    public String getLegmagasabNyeremeny(String suffix) {
        DecimalFormat df = new DecimalFormat();
        String str = df.format((long)this.legmagasabNyeremeny);
        String var10000 = str.replaceAll("\\s+", ",");
        return var10000 + " " + suffix;
    }

    public double getHazaiSzazalek() {
        return this.round(100.0D / (double)(this._1 + this._2 + this._x) * (double)this._1);
    }

    public double getIdegenSzazalek() {
        return this.round(100.0D / (double)(this._1 + this._2 + this._x) * (double)this._2);
    }

    public double getDontetlenSzazalek() {
        return this.round(100.0D / (double)(this._1 + this._2 + this._x) * (double)this._x);
    }

    private double round(double value) {
        double scale = Math.pow(10.0D, 2.0D);
        return (double)Math.round(value * scale) / scale;
    }
}