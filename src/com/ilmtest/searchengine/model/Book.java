package com.ilmtest.searchengine.model;

public class Book implements Comparable<Book>
{
	public int number;
	public String arabic;
	public String english;

	public Book(int bookId, String name)
	{
		super();
		this.number = bookId;
		this.arabic = name;
	}


	public Book(Book b) {
		this(b.number, b.arabic, b.english);
	}


	public Book(Integer bookId, String name, String english)
	{
		this(bookId != null ? bookId : 0, name);
		this.english = english;
	}

	public Book()
	{
	}

	@Override
	public int compareTo(Book o) {
		return number-o.number;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Book [id=" + number + ", arabic=" + arabic + ", english=" + english + "]";
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arabic == null) ? 0 : arabic.hashCode());
		result = prime * result + ((english == null) ? 0 : english.hashCode());
		result = prime * result + number;
		return result;
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
		if (!(obj instanceof Book))
		{
			return false;
		}
		Book other = (Book) obj;
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
		if (number != other.number)
		{
			return false;
		}
		return true;
	}
}