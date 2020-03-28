import java.util.*;
import java.io.*;
import java.lang.*;

///// Main Class

public class Assignment_1
{

  	//// Making Class Company

	public static class Company
	{
		public String Name;
		public int Num_Courses;
		public String[] Courses;				// Courses Eligible
		public int stu_nums;					// Number of students allowed
		public int stu_count=0;					// Number of studets selected
		public String app_stat="OPEN";			

		///// Constructor

		public Company(String Name,int Num_Courses,int stu_nums,String[] Courses)
		{
			this.Name=Name;
			this.Num_Courses=Num_Courses;
			this.stu_nums=stu_nums;
			this.Courses=Courses;
		}

		///// Function to Display
		
		public void display(Company com)
		{	
			if (com.stu_count==stu_nums)
			{	
				app_stat="CLOSED";
			}
			else
			{
				app_stat="OPEN";
			}

			System.out.println(com.Name);

			System.out.println("Course Criteria");
			for (int i=0;i<com.Num_Courses;i++)
			{
				System.out.println(com.Courses[i]);
			}
			System.out.println("Number of Required Students = "+com.stu_nums);
			System.out.println("Application Status: "+app_stat);
		}
	}

	public static class Student
	{
		public int Roll_Number;
		public float cgpa;	
		public String course;
		public String Plac_stat="Not Placed";
		public String company="";
		public ArrayList<String> comps=new ArrayList<String>();			// Companies he has applied for
		public ArrayList<Integer> scores=new ArrayList<Integer>();		// Students scores in the technical interview

		public Student(int Roll_Number,float cgpa,String course)
		{
			this.Roll_Number=Roll_Number;
			this.cgpa=cgpa;
			this.course=course;
		}

		public void Disp_Comp(Student s)
		{
			System.out.println("The Company is: "+s.company);
		}

		public void display(Student s)
		{
			System.out.println(s.Roll_Number);
			System.out.println(s.cgpa);
			System.out.println(s.course);
			System.out.println("Placement Status: "+s.Plac_stat);

			if (s.Plac_stat.equals("Placed"))
			{
				Disp_Comp(s);
			}
		}
	}

	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		int n=Integer.parseInt(in.next());
		ArrayList<Student> students=new ArrayList<Student>();			// ArrayList of students
		ArrayList<Company> companies=new ArrayList<Company>();			// ArrayList of companies
		int[] placed=new int[n];										// Array to keep a check of students who are placed
		int[] students_removed=new int[n];								// Array to keep a check of students who are removed

		for (int i=0;i<n;i++)
		{
			placed[i]=0;
		}

		///// Adding students

		for (int i=0;i<n;i++)
		{
			int Roll_Number=i+1;
			float cgpa=Float.parseFloat(in.next());
			String course=in.next();
			Student new_student=new Student(Roll_Number,cgpa,course);
			students.add(new_student);
		}

		System.out.println("---- students registered ----");

		while (true)
		{

			///// Taking input of the type

			int type=Integer.parseInt(in.next());
		
			// For adding a company

			if (type==1)
			{
				
				String comp_name=in.next();									// Company Name
				System.out.print("Number of eligible courses = ");			
				int num_comp_courses=Integer.parseInt(in.next());			// No of company accepted courses
				String[] comp_courses=new String[num_comp_courses];			
				
				// Taking courses accepted inputs

				for (int i=0;i<num_comp_courses;i++)
				{
					String comp_course=in.next();
					comp_courses[i]=comp_course;
				}
				
				System.out.print("Number of Required Students = ");
				int num_comp_studs=Integer.parseInt(in.next());   						// Number of accepted students by the company
				System.out.println("Application Status = OPEN");			
				System.out.println("Enter scores for the technical round.");

				for (int j=0;j<num_comp_courses;j++)									// Traversing through courses
				{
					for (int i=0;i<students.size();i++)									// Traversing through students
					{
						Student stud=students.get(i);						
						if ((stud.course).equals(comp_courses[j]))						// Checking if a student has that course
						{																	
							System.out.println("Enter score for Roll no. "+(i+1));		
							int score=Integer.parseInt(in.next());						// If the student has one of the course, we are 
							(stud.comps).add(comp_name);								// adding the companies to his applied companies List
							(stud.scores).add(score);									// and adding the score for that companie's interview.
							continue;	
						}
					}
				}

				//	Adding new Company

				Company new_comp=new Company(comp_name,num_comp_courses,num_comp_studs,comp_courses);
				companies.add(new_comp);
			}

			// For displaying a companies details,
			// Doesn't show anything if the company is removed.

			if (type==7)									
			{
				String comp_name=in.next();							
				for (int i=0;i<companies.size();i++)
				{
					Company comp=companies.get(i);
					if (comp.Name.equals(comp_name))
					{
						comp.display(comp);
					}
				}
			}

			// For displaying the details of a student if he is not removed

			if (type==8)
			{
				int roll=Integer.parseInt(in.next());
				int ch_roll=roll-1;
				if (students_removed[ch_roll]!=1)
				{
					Student stud=students.get(ch_roll);
					stud.display(stud);
				}	
			}

			// Displaying companies whose applications are open

			if (type==5)
			{
				for (int i=0;i<companies.size();i++)
				{
					Company comp=companies.get(i);
					if (comp.app_stat.equals("OPEN"))
					{
						System.out.println(comp.Name);
					}
				}
			}

			// For displaying number of students who haven't been placed.

			if (type==4)
			{
				int cnt=0;
				for (int i=0;i<n;i++)
				{
					if (placed[i]==0)
					{
						cnt+=1;
					}
				}
				System.out.println(cnt+" students left.");
			}

			// For displaying the companies and scores of a particular student

			if (type==9)
			{
				int roll=Integer.parseInt(in.next()); 											// Taking in roll number
				int ch_roll=roll-1;																// Updating it(subtracting 1)
				if (students_removed[ch_roll]!=1)												// If he is not removed
				{
					Student stud=students.get(ch_roll);												
					for (int i=0;i<(stud.comps).size();i++)		
					{
						System.out.println((stud.comps).get(i)+" "+(stud.scores).get(i));		// Using the company list in each object of class student,
					}																			// the scores will have the same index as they are taken in in the same order.
				}

				//	If the student is removed no printing.

				else
				{
					System.out.println("No student with the given roll number has an account.");
				}	
			}

			if (type==6)
			{
				int[] studs_to_consider=new int[n];				// Students which have satisfy the branch criteria
				int[] scores_to_compare=new int[n];				// Scores of the students to compare
				String comp_name=in.next();						// Taking in company name
				
				// If company name is not found we move on to next query

				int found=0;									
				for (int i=0;i<companies.size();i++)
				{
					Company comp=companies.get(i);
					if (comp.Name.equals(comp_name))
					{
						found=1;
						break;
					}
				}
				if (found==0)
				{
					continue;
				}
				
				int studs_which_can_be_placed=0;
				
				for (int i=0;i<students.size();i++)
				{
					Student stud=students.get(i);
					if (stud.Plac_stat.equals("Placed")==false)				// If a student is not placed.
					{
						for (int j=0;j<(stud.comps).size();j++)
						{
							String comp=stud.comps.get(j);
							if (comp.equals(comp_name))						// If his course criteria is satified.
							{
								studs_to_consider[i]=1;						// That student will be considered.
								scores_to_compare[i]=stud.scores.get(j);	// Score is noted.
								studs_which_can_be_placed+=1;				// Nummber of students which can be placed are incremented.
							}
						}
					}	
				}

				String[] courses=new String[n];

				// Finding company with the input company name

				Company comp=new Company("No_Name",0,0,courses);
				for (int i=0;i<companies.size();i++)
				{
					comp=companies.get(i);
					if ((comp.Name).equals(comp_name))
					{
						break;
					}
				}					

				if (comp.Name.equals("No_Name")==false)
				{
					int studs_to_be_placed=(comp.stu_nums-comp.stu_count);		// students the company is to take is Max studs it can take - Already in that company
					if (studs_to_be_placed>studs_which_can_be_placed)			// If company can take more than who are eligible it takes all
					{
						for (int i=0;i<students.size();i++)
						{
							if (studs_to_consider[i]==1)
							{
								Student stud=students.get(i);				
								stud.company=comp.Name;							// Student's company assigned
								stud.Plac_stat="Placed";						// Status changed.
								comp.stu_count+=1;								// Company's student strength increased.
								placed[i]=1;									// Student's Roll Number is noted.
							}
						}
					}
					else
					{
						int done=0;
						while (done!=studs_to_be_placed)						// The other case
						{														// Until it takes the number of students required
							int max=-10000000;
							int max_index=-1;
							for (int i=0;i<n;i++)
							{
								if (placed[i]!=1 && studs_to_consider[i]==1)	// If the student is not placed and has the right stream
								{
									if (scores_to_compare[i]>max)				// Checking for maximum technical score
									{
										max=scores_to_compare[i];
										max_index=i;
									}
									else if (scores_to_compare[i]==max)  		// If the technical score is same
									{
										Student stud_1=students.get(i);			// Student1 which has the same score
										Student stud_2=students.get(max_index);	// Student2 which has the same score
										if (stud_1.cgpa>stud_2.cgpa)			// CGPA comparison
										{
											max=scores_to_compare[i];
											max_index=i;
										}
										else
										{
											max=scores_to_compare[i];
										}
									}
								}
							}

							// Best student is placed

							placed[max_index]=1;								// Roll Number is noted.										
							scores_to_compare[max_index]=-1;					// Avoiding any further problems
							done+=1;											// Counter is incremented by 1
							Student stud=students.get(max_index);				
							stud.company=comp_name;								// Company fixed for student
							stud.Plac_stat="Placed";							// Status changed.
						}	
						comp.stu_count+=studs_to_be_placed;						// Company strength is filled with students
						if (comp.stu_nums==comp.stu_count)						// Checking if company is complete or requires more
						{															
							comp.app_stat="CLOSED";								// Changing company status
						}
					}

					// Printing the roll number of selected students by cheking their companies

					System.out.println("Roll Number of Selected Students");
					for (int k=0;k<n;k++)
					{
						Student stud=students.get(k);
						if (stud.company.equals(comp_name))
						{
							System.out.println(k+1);
						}
					}
				}
			}

			// Removal of students accounts

			if (type==2)
			{
				System.out.println("Accounts removed for");
				for (int i=0;i<n;i++)
				{

					// If placed remove

					if (placed[i]==1 && students_removed[i]!=1) 		// just remove 'students_removed[i]!=1' if TA asks to show already removed students
					{
						System.out.println(i+1);
						students_removed[i]=1;
					}
				}
			}

			// Removal of companies

			if (type==3)
			{
				System.out.println("Accounts removed for");
				for (int i=0;i<companies.size();i++)
				{
					Company comp=companies.get(i);
					if (comp.app_stat.equals("CLOSED"))					// If companies full -> application status closed -> remove it.
					{
						System.out.println(comp.Name);
					}
					companies.remove(comp);
				}
			}

			// Calculating number of placed students.

			int placed_count=0;
			for (int i=0;i<n;i++)
			{
				if (placed[i]==1)
				{
					placed_count+=1;
				}
			}

			// If all are placed exit 
			
			if (placed_count==n)
			{
				System.exit(0);
			}
		}
	}
}