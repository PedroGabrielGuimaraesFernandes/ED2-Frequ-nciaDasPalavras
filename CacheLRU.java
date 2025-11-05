import java.util.Map;
import java.util.LinkedHashMap;

public class CacheLRU<K, V> extends LinkedHashMap<K, V> {
private final int capacidade;
public CacheLRU(int capacidade) {
super(capacidade, 0.75f, true); // "true" = ordem por acesso
this.capacidade = capacidade;
}
@Override
protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
return size() > capacidade;
}
}