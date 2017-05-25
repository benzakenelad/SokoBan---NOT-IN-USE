package model.data.gameObjects;

import java.io.Serializable;

public class Target extends GameObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// data members
	private GameObject onMe = null;
	private boolean onMeflag = false;
	private boolean boxOnMeFlag = false;

	// getters and setters
	public void setOnMe(GameObject onMe)// set a game object on the target
	{
		if(this.onMe != null)
			if(this.onMe instanceof Box)
				((Box)this.onMe).setOnTarget(false);
		
		this.onMe = onMe;

		if (onMe != null) {
			setOnMeFlag(true);
			if (onMe instanceof Box){
				((Box)onMe).setOnTarget(true);
				boxOnMeFlag = true;
			}
			else
				boxOnMeFlag = false;
		} else // if onMe is null
		{
			setBoxOnMeFlag(false);
			setOnMeFlag(false);
		}
	}

	public GameObject getOnMe() {
		return onMe;
	}

	public boolean gotGameObjectOnMe() {
		return onMeflag;
	}

	private void setOnMeFlag(boolean onMeflag) {
		this.onMeflag = onMeflag;
	}

	public boolean gotBoxOnMe() {
		return boxOnMeFlag;
	}

	private void setBoxOnMeFlag(boolean boxOnMeFlag) {
		this.boxOnMeFlag = boxOnMeFlag;
	}

	// methods
	@Override
	public String toString() {
		if (onMeflag == true) { // if there is an object on me
			if (onMe instanceof Character)
				return "B";
			else
				return "$";
		} else
			return "o";
	}

}