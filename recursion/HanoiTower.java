/**
 * 汉诺塔问题：
 *  1.有三根杆子A,B,C。A杆上有若干碟子
 *	2.每次移动一块碟子,小的只能叠在大的上面
 *	3.把所有碟子从A杆全部移到C杆上
 * @author Administrator
 *
 */
public class HanoiTower {
	/**topN：代表盘子的数量
	 * from :代表盘子起始的位置
	 * inner:中间经过的塔座
	 * to : 目标塔座
	 */
	public static void doTower(int topN , char from ,char inner , char to ){
		if(topN==1){
			System.out.println("盘子1"+"从"+from+"移动到"+to);
		}else{
			doTower(topN-1, from , to ,inner);
			System.out.println("盘子"+topN+"从"+from+"移动到"+to);
			doTower(topN-1,inner,from ,to);
		}
	}

}
