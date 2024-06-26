package de.school;

public class VerkettetePrimZahlenListe {

    PrimZahlKnoten ersterPrimZahlKnoten = null;

    boolean istLeer() {
        return ersterPrimZahlKnoten == null;
    }

    int anzahlElemente() {
        int anzahl = 0;
        PrimZahlKnoten derzeitigerZaehlKnoten = ersterPrimZahlKnoten;

        while (derzeitigerZaehlKnoten != null) {
            anzahl++;
            derzeitigerZaehlKnoten = derzeitigerZaehlKnoten.naechsterKnoten;
        }

        return anzahl;
    }

    int inhalt(int pIndex) {
        PrimZahlKnoten derzeitigerZaehlKnoten = ersterPrimZahlKnoten;

        for (int i = 0; derzeitigerZaehlKnoten != null; i++) {
            if (i == pIndex) {
                return derzeitigerZaehlKnoten.primZahlWert;
            }
            derzeitigerZaehlKnoten = derzeitigerZaehlKnoten.naechsterKnoten;
        }

        return -1;
    }

    void ersetzen(int pIndex, int pInhalt) {
        PrimZahlKnoten derzeitigerZaehlKnoten = ersterPrimZahlKnoten;

        for (int i = 0; derzeitigerZaehlKnoten != null; i++) {
            if (i == pIndex) {
                derzeitigerZaehlKnoten.primZahlWert = pInhalt;
                return;
            }
            derzeitigerZaehlKnoten = derzeitigerZaehlKnoten.naechsterKnoten;
        }
    }

    void einfuegen(int pIndex, int pInhalt) {
        PrimZahlKnoten neuerPrimZahlKnoten = new PrimZahlKnoten();
        neuerPrimZahlKnoten.primZahlWert = pInhalt;

        if (pIndex <= 0) {
            neuerPrimZahlKnoten.naechsterKnoten = ersterPrimZahlKnoten;
            ersterPrimZahlKnoten = neuerPrimZahlKnoten;
        } else {
            PrimZahlKnoten derzeitigerZaehlKnoten = ersterPrimZahlKnoten;

            for (int i = 0; derzeitigerZaehlKnoten != null; i++) {
                if (i == pIndex - 1) {
                    neuerPrimZahlKnoten.naechsterKnoten = derzeitigerZaehlKnoten.naechsterKnoten;
                    derzeitigerZaehlKnoten.naechsterKnoten = neuerPrimZahlKnoten;
                    return;
                }
                derzeitigerZaehlKnoten = derzeitigerZaehlKnoten.naechsterKnoten;
            }
        }
    }

    void einfuegenVorne(int pInhalt) {
        PrimZahlKnoten neuerPrimZahlKnoten = new PrimZahlKnoten();
        neuerPrimZahlKnoten.primZahlWert = pInhalt;
        neuerPrimZahlKnoten.naechsterKnoten = ersterPrimZahlKnoten;
        ersterPrimZahlKnoten = neuerPrimZahlKnoten;
    }

    void anhaengen(int pInhalt) {
        PrimZahlKnoten neuerPrimZahlKnoten = new PrimZahlKnoten();
        neuerPrimZahlKnoten.primZahlWert = pInhalt;

        if (ersterPrimZahlKnoten == null) {
            ersterPrimZahlKnoten = neuerPrimZahlKnoten;
        } else {
            PrimZahlKnoten derzeitigerZaehlKnoten = ersterPrimZahlKnoten;

            while (derzeitigerZaehlKnoten.naechsterKnoten != null) {
                derzeitigerZaehlKnoten = derzeitigerZaehlKnoten.naechsterKnoten;
            }

            derzeitigerZaehlKnoten.naechsterKnoten = neuerPrimZahlKnoten;
        }
    }

    PrimZahlKnoten entfernen(int pIndex) {
        if (pIndex <= 0) {
            PrimZahlKnoten zuLoeschenderKnoten = ersterPrimZahlKnoten;
            if (ersterPrimZahlKnoten != null) {
                ersterPrimZahlKnoten = ersterPrimZahlKnoten.naechsterKnoten;
            }
            return zuLoeschenderKnoten;
        } else {
            PrimZahlKnoten derzeitigerZaehlKnoten = ersterPrimZahlKnoten;

            for (int i = 0; derzeitigerZaehlKnoten != null; i++) {
                if (i == pIndex - 1 && derzeitigerZaehlKnoten.naechsterKnoten != null) {
                    PrimZahlKnoten zuLoeschenderKnoten = derzeitigerZaehlKnoten.naechsterKnoten;
                    derzeitigerZaehlKnoten.naechsterKnoten = zuLoeschenderKnoten.naechsterKnoten;
                    return zuLoeschenderKnoten;
                }
                derzeitigerZaehlKnoten = derzeitigerZaehlKnoten.naechsterKnoten;
            }
        }

        return null;
    }

    PrimZahlKnoten entfernenVorne() {
        PrimZahlKnoten zuLoeschenderKnoten = ersterPrimZahlKnoten;
        if (ersterPrimZahlKnoten != null) {
            ersterPrimZahlKnoten = ersterPrimZahlKnoten.naechsterKnoten;
        }
        return zuLoeschenderKnoten;
    }

    void entfernenElement(int pInhalt) {
        if (ersterPrimZahlKnoten == null) return;

        if (ersterPrimZahlKnoten.primZahlWert == pInhalt) {
            ersterPrimZahlKnoten = ersterPrimZahlKnoten.naechsterKnoten;
        } else {
            PrimZahlKnoten derzeitigerZaehlKnoten = ersterPrimZahlKnoten;

            while (derzeitigerZaehlKnoten.naechsterKnoten != null) {
                if (derzeitigerZaehlKnoten.naechsterKnoten.primZahlWert == pInhalt) {
                    derzeitigerZaehlKnoten.naechsterKnoten = derzeitigerZaehlKnoten.naechsterKnoten.naechsterKnoten;
                    return;
                }
                derzeitigerZaehlKnoten = derzeitigerZaehlKnoten.naechsterKnoten;
            }
        }
    }

    boolean enthaelt(int pInhalt) {
        PrimZahlKnoten derzeitigerZaehlKnoten = ersterPrimZahlKnoten;

        while (derzeitigerZaehlKnoten != null) {
            if (derzeitigerZaehlKnoten.primZahlWert == pInhalt) {
                return true;
            }
            derzeitigerZaehlKnoten = derzeitigerZaehlKnoten.naechsterKnoten;
        }

        return false;
    }
}
