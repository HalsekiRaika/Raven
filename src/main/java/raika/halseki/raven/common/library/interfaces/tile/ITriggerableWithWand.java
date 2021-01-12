package raika.halseki.raven.common.library.interfaces.tile;

public interface ITriggerableWithWand {
    void onTrigger();
    default void onTriggerWithSneaking() {};
}
