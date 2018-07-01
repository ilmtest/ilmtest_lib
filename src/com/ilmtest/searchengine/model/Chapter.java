package com.ilmtest.searchengine.model;

import com.ilmtest.util.text.TextUtils;

public class Chapter implements Comparable<Chapter>
{
	public static final String BAB_ARABIC = "باب";
	public String arabicTitle;
	public String englishTitle;
	public int number;

	public Chapter()
	{
	}
	
	public Chapter(int number, String arabicTitle) {
		this(arabicTitle, number);
	}
	
	public Chapter(String arabicTitle, int number)
	{
		super();
		this.arabicTitle = arabicTitle;
		this.number = number;
	}
	
	public Chapter(String arabicTitle, int number, String english)
	{
		this(arabicTitle, number);
		this.englishTitle = english;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arabicTitle == null) ? 0 : normalizeTitle(arabicTitle).hashCode());
		//result = prime * result + ((englishTitle == null) ? 0 : englishTitle.hashCode());
		result = prime * result + number;
		return result;
	}

	public static String normalizeTitle(String s) {
		return TextUtils.normalize(s).replaceAll("[^\\p{InArabic}]+", "");
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (!(obj instanceof Chapter))
		{
			return false;
		}
		Chapter other = (Chapter) obj;
		if (arabicTitle == null)
		{
			if (other.arabicTitle != null)
			{
				return false;
			}
		} else if (!normalizeTitle(arabicTitle).equals(normalizeTitle(other.arabicTitle)))
		{
			return false;
		}
		/*if (englishTitle == null)
		{
			if (other.englishTitle != null)
			{
				return false;
			}
		} else if (!englishTitle.equals(other.englishTitle))
		{
			return false;
		} */
		if (number != other.number)
		{
			return false;
		}
		return true;
	}
	

	@Override
	public int compareTo(Chapter o) {
		return number-o.number;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Chapter [" + arabicTitle + ", " + englishTitle + ", " + number + "]";
	}
}