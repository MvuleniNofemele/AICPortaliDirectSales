strSubjectLine = WScript.Arguments.Item(0)
'strSubjectLine = "Sandbox: Verify your identity in Salesforce"
fn_ReadOutlookMsg(strSubjectLine)

Public Function fn_ReadOutlookMsg(strSubjectLine)
               boolSubjectFound = False

				    dim fso: set fso = CreateObject("Scripting.FileSystemObject")
					dim CurrentDirectory
					dim OutputDirectory
					CurrentDirectory = fso.GetAbsolutePathName(".")	
					
               Set appOutl = CreateObject("Outlook.Application")
               Set objSession = appOutl.GetNameSpace("MAPI")
               Set MyFolder = objSession.GetDefaultFolder(6)   '  6 = "Inbox"'  9 = "Calendar"' 10 = "Contacts"
               Set myItems = myFolder.Items
               iMsgCount  =MyFolder.Items.Count
               'Msgbox iMsgCount
               For I = iMsgCount to 1 Step -1
                              
                              If Instr(MyItems(I).subject,strSubjectLine)>0 and (MyItems(I).UnRead = True) Then
                                             slatestSub  = MyItems(I).subject                                            
                                             sLatestTime = MyItems(I).CreationTime
                                             If Cdate(MyItems(I).CreationTime) < DateAdd("n",-50,Now) Then
                                                            boolSubjectFound = false
                                                            Exit For
                                             End If
                                             strBody = MyItems(I).body   
												'msgbox strBody
                                             boolSubjectFound = True
                                             
                                             Exit For
                              End If
               Next
               fn_ReadOutlookMsg = strBody
               If not boolSubjectFound Then
                              'MsgBox "nahi Mila"
               Else
                              Set objFSO=CreateObject("Scripting.FileSystemObject")
                              ' How to write file							  
							  'OutputDirectory = CurrentDirectory + "\downloads"							  
'							  objFSO.CreateFolder OutputDirectory
                              outFile=CurrentDirectory + "\MailData.txt"
                              Set objFile = objFSO.CreateTextFile(outFile,True)
                              objFile.Write strBody
                              objFile.Close
               End If
               
End Function