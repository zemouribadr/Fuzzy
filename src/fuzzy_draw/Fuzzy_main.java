package fuzzy_draw;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fuzzy.Fuzzy;
import fuzzy_param.Fuzzy_function;
import fuzzy_param.Fuzzy_parametre;
import outil.Point;

class Surface extends JPanel {

    private void doDrawing(Graphics g) {
    	Graphics2D g2d = (Graphics2D) g;
    	Fuzzy fuzzy=new Fuzzy();
    	fuzzy.cendroid_converge();
		List<Point>[] clust =fuzzy.cluster();
   		for(int j=0;j<Fuzzy_parametre.getNum_cluster();j++){
   			g2d.setColor(new Color((int)Fuzzy_function.getRandomNumber(0, 255),(int)Fuzzy_function.getRandomNumber(0, 255), (int)Fuzzy_function.getRandomNumber(0, 255)));
   			for(int i=0;i<clust[j].size();i++){
   				Ellipse2D.Double circle =new Ellipse2D.Double(((clust[j].get(i).getX()-Fuzzy_parametre.getValmin_x())*Fuzzy_parametre.getDraw_surface_width())/(Fuzzy_parametre.getValmax_x()-Fuzzy_parametre.getValmin_x())-2.5,Fuzzy_parametre.getDraw_surface_height()-((clust[j].get(i).getY()-Fuzzy_parametre.getValmin_y())*Fuzzy_parametre.getDraw_surface_height())/(Fuzzy_parametre.getValmax_y()-Fuzzy_parametre.getValmin_y())-2.5, 5, 5);
   		        g2d.fill(circle);
   			}
   			Ellipse2D.Double circle =new Ellipse2D.Double(((fuzzy.getFuzzy_data().getCluuster_point(j).getX()-Fuzzy_parametre.getValmin_x())*Fuzzy_parametre.getDraw_surface_width())/(Fuzzy_parametre.getValmax_x()-Fuzzy_parametre.getValmin_x())-7.5,Fuzzy_parametre.getDraw_surface_height()-((fuzzy.getFuzzy_data().getCluuster_point(j).getY()-Fuzzy_parametre.getValmin_y())*Fuzzy_parametre.getDraw_surface_height())/(Fuzzy_parametre.getValmax_y()-Fuzzy_parametre.getValmin_y())-7.5, 15, 15);
   			
		        g2d.fill(circle);
   		}
        
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class Fuzzy_main extends JFrame {

    public Fuzzy_main() {

        initUI();
    }

    private void initUI() {

        add(new Surface());

        setTitle("Simple Java 2D example");
        setSize(Fuzzy_parametre.getDraw_surface_width(), Fuzzy_parametre.getDraw_surface_height());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Fuzzy_main ex = new Fuzzy_main();
                ex.setVisible(true);
            }
        });
    }
}