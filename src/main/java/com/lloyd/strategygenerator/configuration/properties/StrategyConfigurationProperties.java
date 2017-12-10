package com.lloyd.strategygenerator.configuration.properties;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * StrategyConfigurationProperties
 */
@Component
@ConfigurationProperties(prefix = "strategy")
public class StrategyConfigurationProperties {

    private String text;
    private Terms terms;

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

	/**
	 * @return the terms
	 */
	public Terms getTerms() {
		return terms;
	}

	/**
	 * @param terms the terms to set
	 */
	public void setTerms(Terms terms) {
		this.terms = terms;
	}

    /**
     * Terms
     */
    public static class Terms {
		private List<String> nouns;
		private List<String> pluralNouns;
		private List<String> adjectives;

		/**
		 * @return the nouns
		 */
		public List<String> getNouns() {
			return nouns;
		}

		/**
		 * @param nouns the nouns to set
		 */
		public void setNouns(List<String> nouns) {
			this.nouns = nouns;
		}

		/**
		 * @return the pluralNouns
		 */
		public List<String> getPluralNouns() {
			return pluralNouns;
		}

		/**
		 * @param pluralNouns the pluralNouns to set
		 */
		public void setPluralNouns(List<String> pluralNouns) {
			this.pluralNouns = pluralNouns;
		}

		/**
		 * @return the adjectives
		 */
		public List<String> getAdjectives() {
			return adjectives;
		}

		/**
		 * @param adjectives the adjectives to set
		 */
		public void setAdjectives(List<String> adjectives) {
			this.adjectives = adjectives;
		}

    }
}