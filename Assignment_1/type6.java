/*String comp_name=in.next();
				int[] scores_to_compare=new int[n];
				int[] stu_comps=new int[n];
				int tbp=0;
				for (int i=0;i<n;i++)
				{
					for (int j=0;j<students[i].comps.size();j++)
					{
						if (students[i].comps.get(j).equals(comp_name))
						{
							scores_to_compare[i]=students[i].scores.get(j);
							stu_comps[i]=1;
						}
					}
				}
				
				for (int i=0;i<n;i++)
				{
					Company comp=companies.get(i);
					if ((comp.Name).equals(comp_name))
					{
						tbp=comp.stu_nums;
						break;
					}
				}

				//System.out.println("tbp = "+tbp);

				int pl_cnt=0;
				for (int i=0;i<n;i++)
				{
					if (placed[i]==1)
					{
						pl_cnt+=1;
					}
				}

				if ((n-pl_cnt)>tbp)
				{
					int done=0;
					int[] stpl=new int[n];
					while (done!=tbp)
					{

						int max=Integer.MIN_VALUE;
						int max_index=-1;

						for (int i=0;i<n;i++)
						{
							if (placed[i]!=1)
							{
								if (stu_comps[i]==1)
								{
									if (scores_to_compare[i]==max)
									{
										if (students[i].cgpa>students[max_index].cgpa)
										{
											max_index=i;
											stpl[i]=1;
										}
										else
										{
											stpl[max_index]=1;
										}
									}
									else
									{
										if (scores_to_compare[i]>max)
										{
											max=scores_to_compare[i];
										}
									}
								}
							}	
						}
					}
				}*/