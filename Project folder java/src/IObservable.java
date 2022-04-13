public interface IObservable {

    public void assignDwarfToBoard(IObserver dwarf);
    public void releaseDwarfFromBoard(String dwarfName);
    public void notifyDwarfs();
}
