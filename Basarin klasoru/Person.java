abstract class Person {
    private String id;
    private String name;
    private String email;
    
    public Person(){
        this.name = name;
        this.id = id;
        this.email = email;
    }
    abstract void initEmail();

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }


    @Override
    public String toString(){
            return "";
        
    }
}
