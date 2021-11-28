public class Member {
	
	private int id;
	private String name;
	private String email;

	//default constructor
	public Member(){
		this.id = 0;
		this.name = "";
		this.email = "";
	}

	//full arguments constructor
	public Member(int id, String name, String email){
		this.id = id;
		this.name = name;
		this.email = email;
	}

	//takes all arguments as a string array
	public Member(String[] memberInfo){
		this.id = Integer.parseInt(memberInfo[0]);
		this.name = memberInfo[1];
		this.email = memberInfo[2];

	}

	public Member(Member member){
		this.id = member.id;
		this.name = member.name;
		this.email = member.email;
	}

	//starts getter and setter methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	//finishes getter and setter methods

	//reads member file, creates members array and returns this members array.
	public Member[] readMemberFile(){
		FileIO fileIO = new FileIO(); //holds fileIo object
		String allMemberText = fileIO.readFile("Members.csv"); //reads member file
		String[] membersArray = allMemberText.split("\n");
		Member[] memberList = new Member[membersArray.length-2]; //first two lines are not needed
		for (int i = 0; i < memberList.length; i++){
			String[] memberDetail = membersArray[i+2].split(",");
			memberList[i] = new Member(memberDetail);
		}

		return memberList;
	}

	//Takes id as parameter. It finds the member with the same id as the parameter given and returns that member.
	public Member findMember(int id){
		Member[] members = readMemberFile();
		for (Member member : members){
			if (member.id == id){
				return  new Member(member);
			}
		}
		return null;
	}

	public boolean equals(Member otherMember){
		return (id == otherMember.id) &&
				(name.equals(otherMember.name)) &&
				(email.equals(otherMember.email));
	}

	public String toString(){
		return "Id: "+ id + "\nName: " + name + "\nEmail : " + email;
	}
}
