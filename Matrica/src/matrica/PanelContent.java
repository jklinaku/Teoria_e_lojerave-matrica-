package matrica;

/**
 *
 * @author Sead Mejzini && Jon Klinaku
 */
public class PanelContent {

    private final Kalkulimi_i_problemit kp;
    private Object[][] content;

    public PanelContent(Kalkulimi_i_problemit kp) {
        this.kp = kp;
        content = new Object[1][4];
        content[0] = kp.getPrimaryMatrix();
        this.calculateMatrixes();
    }

    public void calculateMatrixes() {
        Matrix tempM = (Matrix) (content[0][0]);
        boolean initial = true;
        boolean end = false;
        while (!end) {
            Object[] temp = kp.updateMatrix(initial);
            if (!(areSame(content[content.length - 1], temp))) {
                content = addObject(content, temp);
            }
            end = kp.getState();
            initial = !initial;
        }
    }

    public Object[][] addObject(Object[][] content, Object[] input) {
        Object[][] temp = new Object[content.length + 1][content[0].length];
        for (int i = 0; i < temp.length - 1; i++) {
            System.arraycopy(content[i], 0, temp[i], 0, temp[0].length);
        }
        temp[temp.length - 1] = input;
        return temp;
    }

    public Object[][] getContent() {
        return content;
    }

    public boolean areSame(Object[] a, Object[] b) {
        boolean ans = true;
        for (int i = 0; i < a.length; i++) {
            ans = ans && a[i] == b[i];
        }
        return ans;
    }
}
