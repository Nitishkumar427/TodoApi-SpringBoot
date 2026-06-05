package com.nitish;

public class Todo  {
	   private Integer userId;
	    private Integer id;
	    private String title;
	    private Boolean iscompleted;
	    
		public Todo(Integer userId, Integer id, String title, Boolean iscompleted) {
			this.userId = userId;
			this.id = id;
			this.title = title;
			this.iscompleted = iscompleted;
		}
		
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public Boolean getCompleted() {
			return iscompleted;
		}
		public void setCompleted(Boolean iscompleted) {
			this.iscompleted = iscompleted;
		}
		@Override
		public String toString() {
			return "Todo [userId=" + userId + ", id=" + id + ", title=" + title + ", iscompleted=" + iscompleted + "]";
		}
	    
	    

}
