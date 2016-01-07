package fuzzy;

import java.util.LinkedList;
import java.util.List;

import fuzzy_param.Fuzzy_function;
import fuzzy_param.Fuzzy_parametre;
import outil.Center;
import outil.Point;

public class Fuzzy {
		Fuzzy_data fuzzy_data;
		private double[][] matrix;
		
		
		public Fuzzy_data getFuzzy_data() {
			return fuzzy_data;
		}
		public void setFuzzy_data(Fuzzy_data fuzzy_data) {
			this.fuzzy_data = fuzzy_data;
		}
		public double[][] getMatrix() {
			return matrix;
		}
		public void setMatrix(double[][] matrix) {
			this.matrix = matrix;
		}
		public Fuzzy() {
			fuzzy_data=new Fuzzy_data(Fuzzy_parametre.getFuzziness(),Fuzzy_parametre.getNum_cluster(), Fuzzy_parametre.getEssaie_number(), Fuzzy_parametre.getValmin_x(),Fuzzy_parametre.getValmax_x(),Fuzzy_parametre.getValmin_y(), Fuzzy_parametre.getValmax_y());
			matrix=new double[Fuzzy_parametre.getEssaie_number()][Fuzzy_parametre.getNum_cluster()];
		}
		public void init()
		{
			for(int i=0;i<Fuzzy_parametre.getEssaie_number();i++){
				for(int j=0;j<Fuzzy_parametre.getNum_cluster();j++){
					matrix[i][j]=euclidien_distance(fuzzy_data.getData_point(i).getX(),fuzzy_data.getData_point(i).getY(),fuzzy_data.getCluuster_point(j).getX() ,fuzzy_data.getCluuster_point(j).getY());
				}
			}
			
		}
		public double euclidien_distance(double x1,double y1,double x2,double y2){
			return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
		}
		public void membership_matrix()
		{
			for(int i=0;i<Fuzzy_parametre.getEssaie_number();i++){
		    	double result=0.0;
				for(int j=0;j<Fuzzy_parametre.getNum_cluster();j++){
					result=result+Math.pow(1/matrix[i][j],1/(fuzzy_data.getFuzziness()-1));
				}
				for(int j=0;j<Fuzzy_parametre.getNum_cluster();j++){
					matrix[i][j]=Fuzzy_function.floorconvert(Math.pow(1/matrix[i][j],1/(fuzzy_data.getFuzziness()-1))/result);
				}
				
			}
		}
		public List<Center> new_cendroid()
		{
			List<Center> center_point=new LinkedList<>();
			for(int j=0;j<Fuzzy_parametre.getNum_cluster();j++){
				double result=0.0,x=0.0,y=0.0;
			for(int i=0;i<Fuzzy_parametre.getEssaie_number();i++){
				result=result+Math.pow(matrix[i][j],fuzzy_data.getFuzziness());
				}
			for(int i=0;i<Fuzzy_parametre.getEssaie_number();i++){

				y=y+Math.pow(matrix[i][j],fuzzy_data.getFuzziness())*fuzzy_data.getData_point(i).getY();
				x=x+Math.pow(matrix[i][j],fuzzy_data.getFuzziness())*fuzzy_data.getData_point(i).getX();
			
			
		}
			center_point.add(new Center(x/result,y/result));
			System.out.println(j+"    "+" X="+x+"   "+result+"    "+ x/result+"    Y="+y/result);
		}
			return center_point;
						
		}
		public void cendroid_converge(){
			boolean cond=true;
			loops:
			while(cond){
				init();
				membership_matrix();
				List<Center> center=new_cendroid();
				
				for(int j=0;j<Fuzzy_parametre.getNum_cluster();j++){
					Double x1=center.get(j).getX();
					Double y1=center.get(j).getY();
					if(x1.isNaN() || y1.isNaN()){
						break loops;
					}
					if(Math.abs(center.get(j).getX()-fuzzy_data.getCluuster_point(j).getX())<Fuzzy_parametre.getEpsilon() && Math.abs(center.get(j).getY()-fuzzy_data.getCluuster_point(j).getY())<Fuzzy_parametre.getEpsilon()){
						cond=false;
					}
					else{
						cond=true;
					}
				}
				
					fuzzy_data.setCluster_point(center);
				
			}
		}
		public List<Point>[] cluster()
		{
			List<Point>[] cluster=new List[Fuzzy_parametre.getNum_cluster()];
			for(int i=0;i<Fuzzy_parametre.getNum_cluster();i++){
				cluster[i]=new LinkedList<>();
			}
			for(int i=0;i<Fuzzy_parametre.getEssaie_number();i++){
				int max=0;
				double value=0;
				for(int j=0;j<Fuzzy_parametre.getNum_cluster();j++){
					if(matrix[i][j]>value){
						max=j;
						value=matrix[i][j];
					}
					}
				cluster[max].add(fuzzy_data.getData_point(i));
			}
			return cluster;
		}

	
		

			
}
