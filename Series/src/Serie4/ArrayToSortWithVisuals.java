package Serie4;

import javax.swing.*;
import java.awt.*;

public class ArrayToSortWithVisuals extends ArrayToSort<Integer> {

    @Override
    public void exch(int firstIndex, int secondIndex) {
        super.exch(firstIndex, secondIndex);
        LastOp = OpType.Swap;
        swapFirst = firstIndex;
        swapSecond = secondIndex;
        frame.repaint();
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isLess(int firstIndex, int secondIndex) {

        compareFirst = firstIndex; compareSecond = secondIndex;
        LastOp = OpType.Compare;

        if (frame != null)
        {
            frame.repaint();
        }
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return super.isLess(firstIndex, secondIndex);
    }

    public ArrayToSortWithVisuals(Integer[] array, int delay) {
        super(array);
        this.delay = delay;
        frame = new JFrame("Visualization");
        Visualization visualization = new Visualization();
        frame.getContentPane().add(visualization);
        frame.setSize(totalWidth(), totalHeigth());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        visualization.repaint();
    }

    private JFrame frame;
    private int delay;
    private enum OpType {None, Swap, Compare};

    private OpType LastOp = OpType.None;
    private int compareFirst, compareSecond;
    private int swapFirst, swapSecond;

    private int width = 600;
    private int heightOfBars = 300;
    private int margin = 20;
    private int heightOfCompare = 30;
    private int heightOfText = 20;

    private int totalHeigth () {
        return 2 * margin + heightOfBars + heightOfCompare + heightOfText;
    }

    private int totalWidth () {
        return 2 * margin + width;
    }

    private class Visualization extends JPanel {

        private String getText () {
            String str = "";
            if (LastOp == OpType.Swap) {
                str += String.format("swaped element %d and %d", swapFirst, swapSecond);
            }
            if (LastOp == OpType.Compare) {
                str += String.format("compared elements %d and %d", compareFirst, compareSecond);
            }
            str += "       ";
            str += "#Cmp=" + cmpCounter + ", #exch=" + swapCounter;
            str += "       ";
            str += "isSorted=" + (isSorted()? "True" : "False");
            return str;
        }

        public void paint (Graphics g) {
            int len = array.length;
            int pxPerElem = width / (2 * len - 1);

            Integer minElem = cheatSolution[0] - 1;
            Integer maxElem = cheatSolution[len-1];

            for (int i = 0; i < len; i++) {
                if (array[i].compareTo(cheatSolution[i]) == 0) {
                    g.setColor(Color.gray);
                } else {
                    g.setColor(Color.black);
                }
                if ((swapFirst == i || swapSecond == i) && swapFirst != swapSecond) { // LastOp == OpType.exch && ??
                    g.setColor(Color.red);
                }
                int height = heightOfBars * (array[i] - minElem) / (maxElem - minElem);
                g.fillRect(margin + (2 * i -1) * pxPerElem, margin + heightOfBars - height, pxPerElem, height);
            }

            g.setColor(Color.black);

            int x1 = margin + (2 * compareFirst - 1) * pxPerElem + pxPerElem / 2;
            int x2 = margin + (2 * compareSecond - 1) * pxPerElem + pxPerElem / 2;

            g.drawLine(x1, margin + heightOfBars + heightOfCompare / 2,
                       x2,margin + heightOfBars + heightOfCompare / 2);

            g.drawLine(x1, margin + heightOfBars, x1, margin + heightOfBars + heightOfCompare / 2);
            g.drawLine(x2, margin + heightOfBars, x2, margin + heightOfBars + heightOfCompare / 2);

            g.setColor(Color.black);
            g.drawString(getText(), margin, margin + heightOfCompare + heightOfBars + heightOfText);

        }
    }

}
