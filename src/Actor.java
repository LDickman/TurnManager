public interface Actor {
    default String getName() {
        return "Ben";
    }

    default int geSpeed() {
        return 20;
    }
}
