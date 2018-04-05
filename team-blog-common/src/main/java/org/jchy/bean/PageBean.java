package org.jchy.bean;

import java.util.List;

public class PageBean<T> {

	private final int page;

	private final int size;

	private final int total;

	private final List<T> datas;

	public PageBean(List<T> datas, int page, int size, int total) {
		this.datas = datas;
		this.page = page;
		this.size = size;
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public int getSize() {
		return size;
	}

	public int getTotal() {
		return total;
	}

	public List<T> getDatas() {
		return datas;
	}

}
