package org.corpus_tools.salt.util.internal;

import java.util.ArrayList;
import java.util.Collection;

public class Validator {

	public static class Builder<T extends Object> {
		private final T saltObject;

		public Builder(T saltObject) {
			this.saltObject = saltObject;
		}

		public boolean andGetResult() {
			return false;
		}

		public Collection<String> andFindProblems() {
			return new ArrayList<>();
		}
	}

	public Validator() {
		// TODO Auto-generated constructor stub
	}

}
