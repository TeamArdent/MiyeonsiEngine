package kr.pe.ardent.miyeonsi_engine.libs;

public interface GameObjectInterface
{
    public void onCreate(Scene scene);
    public void onUpdate(Scene scene);
    public void onSceneMouseDown(Scene scene, int x, int y, int pointer);
    public void onMouseDown(Scene scene, int x, int y, int pointer);
    public void onSceneMouseUp(Scene scene, int x, int y, int pointer);
    public void onMouseUp(Scene scene, int x, int y, int pointer);
    public void onSceneMouseDrag(Scene scene, int x, int y);
    public void onMouseDrag(Scene scene, int x, int y);
    public void onSceneMouseMove(Scene scene, int x, int y);
    public void onMouseMove(Scene scene, int x, int y);
}
