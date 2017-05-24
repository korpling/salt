package org.corpus_tools.salt.index;

import java.io.Serializable;

public class IndexID<K, V> implements Serializable {
	private static final long serialVersionUID = -4027959633961940459L;
	private final String indexId;
	private final Class<K> keyClass;
	private final Class<V> valueClass;

	public IndexID(String indexId, Class<K> keyClass, Class<V> valueClass) {
		super();
		this.indexId = indexId;
		this.keyClass = keyClass;
		this.valueClass = valueClass;
	}

	public String getIndexId() {
		return indexId;
	}

	public Class<K> getKeyClass() {
		return keyClass;
	}

	public Class<V> getValueClass() {
		return valueClass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((indexId == null) ? 0 : indexId.hashCode());
		result = prime * result + ((keyClass == null) ? 0 : keyClass.hashCode());
		result = prime * result + ((valueClass == null) ? 0 : valueClass.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IndexID<?, ?> other = (IndexID<?, ?>) obj;
		if (indexId == null) {
			if (other.indexId != null)
				return false;
		} else if (!indexId.equals(other.indexId))
			return false;
		if (keyClass == null) {
			if (other.keyClass != null)
				return false;
		} else if (!keyClass.equals(other.keyClass))
			return false;
		if (valueClass == null) {
			if (other.valueClass != null)
				return false;
		} else if (!valueClass.equals(other.valueClass))
			return false;
		return true;
	}
}