package lessons.recursion.hanoi;

import lessons.recursion.hanoi.universe.HanoiEntity;
import plm.core.model.Game

class ScalaTricolorHanoi2Entity(game: Game) extends HanoiEntity(game) {

	override def run() {
    val src = getParam(0).asInstanceOf[Int]
    val mid = getParam(1).asInstanceOf[Int]
    val dst = getParam(2).asInstanceOf[Int]
    gather(getSlotSize(src), src, mid, dst)
	}

	/* BEGIN TEMPLATE */
	def gather(height:Int, src:Int, mid:Int, dst:Int) {
		/* BEGIN SOLUTION */
    if (height >0) {
      gather(height-1,src,mid,dst);
      move(src,mid);
      move3(height-1, dst,mid,src);
      move(mid,dst);
      move(mid,dst);
      move3(height-1, src, mid, dst);
    }
	}

  def move3(height:Int, src:Int, mid:Int, dst:Int) {
    if (height>0) {
      move3(height-1, src, dst, mid);
      move(src,dst);
      move(src,dst);
      move(src,dst);
      move3(height-1, mid, src, dst);
    }
		/* END SOLUTION */
	}
	/* END TEMPLATE */
}
