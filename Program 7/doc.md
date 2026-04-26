# Program 7: Basics of Ansible: Inventory, Playbooks, and Modules, Automating Server Conﬁgurations with Playbooks, Hands-On: Writing and Running a Basic Playbook

---

## Inventory:

Inventory is a ﬁle that contains list of target machines where Ansible runs tasks.
It deﬁnes hosts and connection details like localhost or remote systems.

---

## Playbook:

Playbook is a YAML ﬁle that deﬁnes tasks to be executed on hosts.
It is used to automate conﬁguration and operations step-by-step.

---

## Module:

Module is a small unit of work used inside playbooks.
Examples include ping, copy, file, service, and debug.

---

## Step 1: Install WSL (Ubuntu) [For Windows Users]

If WSL is not installed, run:

```bash id="7c4t6c"
wsl --install
```

Restart system → Open Ubuntu → Set username & password.

---

## Step 2: Install Ansible in Ubuntu

```bash id="o6i0qa"
sudo apt update
sudo apt install ansible -y
```

---

## Step 3: Check Ansible is Installed

```bash id="6vh5py"
ansible --version
```

---

## Step 4: Test Connection with localhost - Create or edit the Ansible inventory ﬁle

```bash id="c4bqmn"
sudo mkdir -p /etc/ansible
sudo nano /etc/ansible/hosts
```

Add:

```ini id="7j6kts"
[local]
localhost ansible_connection=local
```

---

Then test:

```bash id="45wr7o"
ansible localhost -m ping
```

(You should see a “pong” response indicating success)

---

## Step 5: Create a Directory for Playbooks

```bash id="k4y6g1"
mkdir ~/ansible-playbooks
cd ~/ansible-playbooks
```

---

## Step 6: Create First Playbook File - Create the ﬁle firstpb.yml

```bash id="q2e0zn"
nano firstpb.yml
```

Code:

```yaml id="e3yy23"
---
- name: First Basic PB
  hosts: localhost

  tasks:
    - name: Test Connectivity
      ping:

    - name: Print Output
      debug:
        msg: "Alright!!"
```

After writing the code, save the ﬁle and exit the editor.

---

## Step 7: Run the Playbook

```bash id="9e9dbp"
ansible-playbook firstpb.yml
```

---

You should see both:

* ping success message
* debug output: "Alright!!"

---
