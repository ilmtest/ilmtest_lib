package com.ilmtest.searchengine.model;

public class Entry implements Comparable<Entry>
{
	public int id;
	public Book book = new Book();
	public Chapter chapter = new Chapter();
	public String arabic;
	public String english;
	public String arabicGrade;
	public String englishGrade;
	public String commentary = new String();
	public String arabicIndex;
	public String englishIndex;
	public Part part;
	public int pageNumber;

	public Entry()
	{
	}
	
	public Entry(String arabic) {
		this.arabic = arabic;
	}
	
	public Entry(int id)
	{
		this.id = id;
	}

	@Override
	public int compareTo(Entry o) {
		return id-o.id;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Entry clone()
	{
		Entry n = new Entry();
		n.arabic = this.arabic;
		n.arabicIndex = this.arabicIndex;
		n.book = this.book;
		n.chapter = this.chapter;
		n.english = this.english;
		n.englishIndex = this.englishIndex;
		n.arabicGrade = this.arabicGrade;
		n.id = this.id;
		n.englishGrade = this.englishGrade;
		
		return n;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return id;
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
		if (!(obj instanceof Entry))
		{
			return false;
		}
		Entry other = (Entry) obj;
		if (arabic == null)
		{
			if (other.arabic != null)
			{
				return false;
			}
		} else if (!arabic.equals(other.arabic))
		{
			return false;
		}
		if (arabicIndex == null)
		{
			if (other.arabicIndex != null)
			{
				return false;
			}
		} else if (!arabicIndex.equals(other.arabicIndex))
		{
			return false;
		}
		if (book == null)
		{
			if (other.book != null)
			{
				return false;
			}
		} else if (!book.equals(other.book))
		{
			return false;
		}
		if (chapter == null)
		{
			if (other.chapter != null)
			{
				return false;
			}
		} else if (!chapter.equals(other.chapter))
		{
			return false;
		}
		if (english == null)
		{
			if (other.english != null)
			{
				return false;
			}
		} else if (!english.equals(other.english))
		{
			return false;
		}
		if (englishIndex == null)
		{
			if (other.englishIndex != null)
			{
				return false;
			}
		} else if (!englishIndex.equals(other.englishIndex))
		{
			return false;
		}
		if (arabicGrade == null)
		{
			if (other.arabicGrade != null)
			{
				return false;
			}
		} else if (!arabicGrade.equals(other.arabicGrade))
		{
			return false;
		}
		if (englishGrade == null)
		{
			if (other.englishGrade != null)
			{
				return false;
			}
		} else if (!englishGrade.equals(other.englishGrade))
		{
			return false;
		}
		if (id != other.id)
		{
			return false;
		}
		return true;
	}
	
	public void setPart(int pageNumber, int partNumber, int partPage)
	{
		this.pageNumber = pageNumber;
		this.part = new Part(partNumber, partPage);
	}
	
	public int getIndex()
	{
		if (arabicIndex == null) {
			return 0;
		}
		
		if ( arabicIndex.contains(",") ) {
			arabicIndex = arabicIndex.split(", ")[0];
		} else if ( arabicIndex.contains("-") ) {
			arabicIndex = arabicIndex.split("-")[0];
		} else if ( arabicIndex.contains(" ") ) {
			arabicIndex = arabicIndex.split(" ")[0];
		} else if ( !arabicIndex.matches("^\\d+$") ) {
			arabicIndex = "0";
		}
		
		try {
			return Integer.parseInt(arabicIndex);
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public class Part
	{
		public int number;
		public int page;

		public Part(int number, int page)
		{
			this.number = number;
			this.page = page;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString()
		{
			return number + "/" + page;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Entry [id=" + id + ", book=" + book + ", chapter=" + chapter + ", english="
				+ english + ", arabicGrade=" + arabicGrade + ", englishGrade=" + englishGrade + ", commentary="
				+ commentary + ", arabicIndex=" + arabicIndex + ", englishIndex=" + englishIndex + ", part=" + part
				+ ", pageNumber=" + pageNumber + "]";
	}
}