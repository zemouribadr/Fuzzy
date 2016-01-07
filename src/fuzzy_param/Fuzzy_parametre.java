package fuzzy_param;

public class Fuzzy_parametre {
	private static int essaie_number=1000;
	private static int num_cluster=7;
	private static double fuzziness=1.25;
	private static double valmax_x=500;
	private static double valmin_x=0;
	private static double valmax_y=1000;
	private static double valmin_y=500;
	private static double after_dot=3;
	private static int draw_surface_height=500;
	private static int draw_surface_width=500;
	private static double epsilon=0.009;
	
	
	public static double getEpsilon() {
		return epsilon;
	}
	public static void setEpsilon(double epsilon) {
		Fuzzy_parametre.epsilon = epsilon;
	}
	public static int getDraw_surface_height() {
		return draw_surface_height;
	}
	public static void setDraw_surface_height(int draw_surface_height) {
		Fuzzy_parametre.draw_surface_height = draw_surface_height;
	}
	public static int getDraw_surface_width() {
		return draw_surface_width;
	}
	public static void setDraw_surface_width(int draw_surface_width) {
		Fuzzy_parametre.draw_surface_width = draw_surface_width;
	}
	public static double getAfter_dot() {
		return after_dot;
	}
	public static void setAfter_dot(double after_dot) {
		Fuzzy_parametre.after_dot = after_dot;
	}
	public static int getEssaie_number() {
		return essaie_number;
	}
	public static void setEssaie_number(int essaie_number) {
		Fuzzy_parametre.essaie_number = essaie_number;
	}
	public static double getFuzziness() {
		return fuzziness;
	}
	public static void setFuzziness(double fuzziness) {
		Fuzzy_parametre.fuzziness = fuzziness;
	}
	public static int getNum_cluster() {
		return num_cluster;
	}
	public static void setNum_cluster(int num_cluster) {
		Fuzzy_parametre.num_cluster = num_cluster;
	}
	public static double getValmax_x() {
		return valmax_x;
	}
	public static void setValmax_x(double valmax_x) {
		Fuzzy_parametre.valmax_x = valmax_x;
	}
	public static double getValmin_x() {
		return valmin_x;
	}
	public static void setValmin_x(double valmin_x) {
		Fuzzy_parametre.valmin_x = valmin_x;
	}
	public static double getValmax_y() {
		return valmax_y;
	}
	public static void setValmax_y(double valmax_y) {
		Fuzzy_parametre.valmax_y = valmax_y;
	}
	public static double getValmin_y() {
		return valmin_y;
	}
	public static void setValmin_y(double valmin_y) {
		Fuzzy_parametre.valmin_y = valmin_y;
	}
	
	
}
