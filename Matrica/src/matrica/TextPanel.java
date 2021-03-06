package matrica;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Sead Mejzini && Jon Klinaku
 */
public class TextPanel extends AbstractPanel {

    public TextPanel(PanelContent p) {
        super(p);

    }

    @Override
    public void update(int count) {
        removeAll();
        Object[] temp = content[count];
        Matrix[] m = new Matrix[2];
        m[0] = (Matrix) (temp[0]);
        m[1] = (Matrix) (temp[1]);
        String[] s1 = (String[]) temp[2];
        String[] s2 = (String[]) temp[3];

        JTextArea ta = new JTextArea("");
        ta.setEditable(false);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);

        JScrollPane scroller = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        Object el = null, t = null;
        try {
            el = content[count + 1][4];
            t = content[count + 1][5];

            if (count == 0) {
                if (s1.length == s2.length) {
                    ta.append(" Qe te dy nga lojtaret kane nga " + s1.length + " strategji. Lojetari i pare ka strategjite: ");
                    for (int i = 0; i < s1.length - 1; i++) {
                        ta.append(s1[i] + ", ");
                    }
                    ta.append(s1[s1.length - 1] + " ndersa lojetari i dyte ka strategjite: ");
                    for (int i = 0; i < s1.length - 1; i++) {
                        ta.append(s2[i] + ", ");
                    }
                    ta.append(s2[s1.length - 1] + ".");
                } else {
                    ta.append(" Lojetari i pare ka  " + s1.length + " strategji, ndersa lojetari i dyte ka " + s2.length + " strategji. Lojetari i pare ka strategjite: ");
                    for (int i = 0; i < s1.length - 1; i++) {
                        ta.append(s1[i] + ", ");
                    }
                    ta.append(s1[s1.length - 1] + " ndersa lojetari i dyte ka strategjite: ");
                    for (int i = 0; i < s2.length - 1; i++) {
                        ta.append(s2[i] + ", ");
                    }
                    ta.append(s2[s2.length - 1] + ".");

                }
            }

            if (el instanceof Integer) {
                if ((boolean) t) {
                    ta.append("Strategjia " + s1[(int) (el)] + " eshte dominuese ndaj te gjithe strategjive"
                                             + " tjera per lojtarin e pare.");
                } else {
                    ta.append("Strategjia " + s2[(int) (el)] + " eshte dominuese ndaj te gjithe strategjive"
                                             + " tjera per lojtarin e dyte.");
                }

            } else if (el instanceof int[][]) {
                int[][] em = (int[][]) el;
                em = transpose(em);
//                for (int i = 0; i < em.length; i++) {
//                    for (int j = 0; j < em[0].length; j++) {
//                        System.out.print(em[i][j]);
//                    }
//                    System.out.println();
//                }
                if ((boolean) t) {
                    ta.append(" Asnjera nga strategjite e lojtarit te pare nuk eshte rigorozisht dominuese"
                                             + " ndaj te gjitha strategjive tjera per lojtarin e pare.");
                    for (int i = 0; i < s1.length; i++) {
                        int d = dominates(em[i]);
                        if (d == 1) {
                            continue;
                        }
                        ta.append(" Strategjia " + s1[i] + "dominon strategjite: ");
                        for (int j = 0; j < s1.length; j++) {
                            if (i == j) {
                                continue;
                            }
                            if (em[i][j] == 1) {
                                ta.append(s1[j] + " ");
                            }
                        }
                        ta.append("\n");
                    }
                } else {
                    ta.append(" Asnjera nga strategjite e lojtarit te dyte nuk eshte rigorozisht dominuese"
                                             + " ndaj te gjitha strategjive tjera per lojtarin e dyte. ");
                    for (int i = 0; i < s2.length; i++) {
                        int d = dominates(em[i]);
                        if (d == 1) {
                            continue;
                        }
                        ta.append(" Strategjia " + s2[i] + "dominon strategjite: ");
                        for (int j = 0; j < s2.length; j++) {
                            if (i == j) {
                                continue;
                            }
                            if (em[i][j] == 1) {
                                ta.append(s2[j] + "  ");
                            }
                        }
                        ta.append("\n");
                    }
                }
            } else {
                int[] em = (int[]) el;
                ta.append(" Asnjera nga strategjite e lojtarit te ");
                if ((boolean) t) {
                    ta.append("pare nuk eshte as rigorozisht dominuese e as nuk ka strategji te dominuar,"
                                             + " prandaj bejm eleminimin e strategjive shumave te elementeve perkatese,"
                                             + " ku shuma me e vogel largohet   .\n");
                    ta.append("Strategjia-te: ");
                    for (int i = 0; i < em.length; i++) {
                        if (em[i] == 1) {
                            ta.append(s1[i] + " ");
                        }
                    }
                    ta.append("eleminohen!\n");
                } else {
                    ta.append("dyte nuk eshte as rigorozisht dominuese e as nuk ka strategji te dominuar,"
                                             + " prandaj bejm eleminimin e strategjive shumave te elementeve perkatese,"
                                             + " ku shuma me e vogel largohet   .\n");
                    ta.append("Strategjia-te: ");
                    for (int i = 0; i < em.length; i++) {
                        if (em[i] == 1) {
                            ta.append(s2[i] + " ");
                        }
                    }
                    ta.append("eleminohen!\n");
                }
            }
        } catch (Exception e) {
            ta.append("Pas eleminimit iterativ te strategjive dominuese,"
                                     + "te dominuara si dhe atyre me shance me te vogel arrijm ne perfundim "
                                     + "se nese te dy lojtaret veprojn ne menyr racionale atehere lojtari i pare"
                                     + " do te zgjedh strategjine: " + s1[0] + " , ndersa lojtari i dyte do te "
                                     + "zgjedh strategjin: " + s2[0]);
        }

        add(scroller);
        revalidate();
    }

    private int dominates(int[] input) {
        int counter = 0;
        for (int i = 0; i < input.length; i++) {
            counter = counter + input[i];
        }
        return counter;
    }

    private int[][] transpose(int[][] input) {
        int[][] ans = new int[input.length][input[0].length];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                ans[i][j] = input[j][i];
            }
        }
        return ans;
    }
}
