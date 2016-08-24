package info.dgsoft.restful.api.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import info.dgsoft.restful.api.domain.base.DomainBase;

@Entity
@Table(name = "services")
public class DGService extends DomainBase
{

	private static final long serialVersionUID = 4615439859787718099L;
	@Id
	@Column(name = "id")
	private int id;
	private String name;
	private String url;

	public DGService()
	{
	}

	public DGService(int id, String name, String url)
	{
		this.id = id;
		this.name = name;
		this.url = url;
	}

	public int getId()
	{
		return this.id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getUrl()
	{
		return this.url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public boolean equals(Object other)
	{
		if ((this == other)) return true;
		if ((other == null)) return false;
		if (!(other instanceof DGService)) return false;
		DGService castOther = (DGService) other;

		return (this.getId() == castOther.getId())
				&& ((this.getName() == castOther.getName())
						|| (this.getName() != null && castOther.getName() != null
								&& this.getName().equals(castOther.getName())))
				&& ((this.getUrl() == castOther.getUrl()) || (this.getUrl() != null
						&& castOther.getUrl() != null && this.getUrl().equals(castOther.getUrl())));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + this.getId();
		result = 37 * result + (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result + (getUrl() == null ? 0 : this.getUrl().hashCode());
		return result;
	}

}
