import { Fragment, useState } from "react";
import { Dialog, Disclosure, Menu, Transition } from "@headlessui/react";
import { XMarkIcon } from "@heroicons/react/24/outline";
import { ChevronDownIcon, Bars3Icon } from "@heroicons/react/20/solid";
import logo from "../../assets/logo.png";
import { Link, Outlet } from "react-router-dom";
import BackgroundImage from "./BackgroundImage";

const sortOptions = [
  { name: "Cambiar contraseña", href: "#", current: false },
  { name: "Cerrar sesión", href: "#", current: false },
];

const subCategories = [
  { name: "Estadistica", href: "/dash/stat" },
  { name: "Formulario", href: "/dash/form" },
  { name: "Tabla", href: "/dash/tab" },
];

function classNames(...classes) {
  return classes.filter(Boolean).join(" ");
}

export default function Dashboard() {
  const [mobileFiltersOpen, setMobileFiltersOpen] = useState(false);

  return (
    <div className="relative isolate overflow-hidden bg-gray-900">
      <BackgroundImage />

      <Transition.Root show={mobileFiltersOpen} as={Fragment}>
        <Dialog
          as="div"
          className="relative z-40 lg:hidden"
          onClose={setMobileFiltersOpen}
        >
          <Transition.Child
            as={Fragment}
            enter="transition-opacity ease-linear duration-300"
            enterFrom="opacity-0"
            enterTo="opacity-100"
            leave="transition-opacity ease-linear duration-300"
            leaveFrom="opacity-100"
            leaveTo="opacity-0"
          >
            <div className="fixed inset-0 bg-black bg-opacity-25" />
          </Transition.Child>

          <div className="fixed inset-0 z-40 flex">
            <Transition.Child
              as={Fragment}
              enter="transition ease-in-out duration-300 transform"
              enterFrom="translate-x-full"
              enterTo="translate-x-0"
              leave="transition ease-in-out duration-300 transform"
              leaveFrom="translate-x-0"
              leaveTo="translate-x-full"
            >
              <Dialog.Panel className="relative ml-auto flex h-full w-full max-w-xs flex-col overflow-y-auto bg-white py-4 pb-12 shadow-xl">
                <div className="flex items-center justify-between px-4">
                  <h2 className="text-lg font-medium text-gray-900"></h2>
                  <button
                    type="button"
                    className="-mr-2 flex h-10 w-10 items-center justify-center rounded-md bg-white p-2 text-gray-400"
                    onClick={() => setMobileFiltersOpen(false)}
                  >
                    <XMarkIcon
                      className="h-6 w-6 text-black"
                      aria-hidden="true"
                    />
                  </button>
                </div>

                <form className="mt-4 border-t border-gray-200">
                  <ul role="list" className="px-2 py-3 font-medium text-gray-900">
                    {subCategories.map((category) => (
                      <li key={category.name}>
                        <Link to={category.href} className="block px-2 py-3">
                          {category.name}
                        </Link>
                      </li>
                    ))}
                  </ul>
                </form>
              </Dialog.Panel>
            </Transition.Child>
          </div>
        </Dialog>
      </Transition.Root>

      <main className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-0">
        <div
          className="rounded-b-3xl border-b-2 border-[#FFFFFF] bg-[#100C18] mx-auto flex max-w-7xl items-center justify-between p-6 lg:px-8"
          aria-label="Global"
        >
          <div className="flex lg:flex-1">
            <a href="#" className="-m-1.5 p-1.5">
              <span className="sr-only">Dame tu Mano</span>
              <img className="h-10 w-auto" src={logo} alt="" />
            </a>
          </div>

          <div className="flex items-center">
            <Menu as="div" className="relative inline-block text-left">
              <div>
                <Menu.Button className="group inline-flex justify-center text-sm font-medium text-white hover:text-[#E37B3A]">
                  Usuario
                  <ChevronDownIcon
                    className="-mr-1 ml-1 h-5 w-5 flex-shrink-0 text-white group-hover:text-[#E37B3A]"
                    aria-hidden="true"
                  />
                </Menu.Button>
              </div>

              <Transition
                as={Fragment}
                enter="transition ease-out duration-100"
                enterFrom="transform opacity-0 scale-95"
                enterTo="transform opacity-100 scale-100"
                leave="transition ease-in duration-75"
                leaveFrom="transform opacity-100 scale-100"
                leaveTo="transform opacity-0 scale-95"
              >
                <Menu.Items className="absolute right-0 z-10 mt-2 w-40 origin-top-right rounded-md bg-white shadow-2xl ring-1 ring-black ring-opacity-5 focus:outline-none">
                  <div className="py-1">
                    {sortOptions.map((option) => (
                      <Menu.Item key={option.name}>
                        {({ active }) => (
                          <a
                            href={option.href}
                            className={classNames(
                              option.current
                                ? "font-medium text-gray-900"
                                : "text-gray-500",
                              active ? "bg-gray-100" : "",
                              "block px-4 py-2 text-sm"
                            )}
                          >
                            {option.name}
                          </a>
                        )}
                      </Menu.Item>
                    ))}
                  </div>
                </Menu.Items>
              </Transition>
            </Menu>

            <button
              type="button"
              className="-m-2 ml-4 p-2 text-white hover:text-[#E37B3A] sm:ml-6 lg:hidden"
              onClick={() => setMobileFiltersOpen(true)}
            >
              <span className="sr-only">Filters</span>
              <Bars3Icon className="h-5 w-5" aria-hidden="true" />
            </button>
          </div>
        </div>

        <section aria-labelledby="products-heading" className="pb-6 pt-6">
          <div className="grid grid-cols-1 p-2 gap-x-8 gap-y-10 lg:grid-cols-4">
            <form className="hidden lg:block">
              <div className="bg-[#100C18] text-base text-white h-full border border-white rounded-2xl px-3 py-3">
                <ul role="list" className="space-y-4 pb-6 font-medium">
                  {subCategories.map((category) => (
                    <li key={category.name}>
                      <Link className="p-4" to={category.href}>
                        {category.name}
                      </Link>
                    </li>
                  ))}
                </ul>
              </div>
            </form>

            <div className="lg:col-span-3 py-2">
              {/*ESTO HACE LA MAGIA*/}
              <Outlet />
            </div>

          </div>
        </section>
      </main>
    </div>
  );
}
