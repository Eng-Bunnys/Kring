package Objects.Player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

public abstract class GameEntity {

    protected float x,y,velx,vely,speed;
    protected float width, height;
    protected Body body;

    public GameEntity(float width, float height, Body body){
        this.x=body.getPosition().x;
        this.y=body.getPosition().y;
        this.width=width;
        this.height=height;
        this.body=body;
        this.velx=0;
        this.vely=0;
        this.speed=0;
    }

    public abstract void update();
    public abstract void render(SpriteBatch batch);
    public Body getBody(){
        return body;
    }

}
